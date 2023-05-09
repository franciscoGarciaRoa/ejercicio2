package com.pruebaTecnicaFJGR.ejercicio2;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import com.pruebaTecnicaFJGR.ejercicio2.bean.Book;
import com.pruebaTecnicaFJGR.ejercicio2.bean.BookDate;
import com.pruebaTecnicaFJGR.ejercicio2.bean.BookComparator;

@SpringBootApplication
public class Ejercicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			// Carga de los libros en un List
			InputStream is = getClass().getClassLoader().getResourceAsStream("books.json");
			ObjectMapper mapper = new ObjectMapper();
			List<Book> books = mapper.readValue(is, new TypeReference<List<Book>>() {
			});

			// Leer cadena de entrada
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduzca la cadena a buscar: ");
			String filter = br.readLine();

			// Llamada a la funcion de filtro
			filter(filter, books);

		};
	}

	private Optional<BookDate> filter(String filter, List<Book> books) {
		
		System.out.println("Libros sin fecha de publicacion: ");
		books.stream().forEach((book)-> {
			if (book.getPublicationTimestamp() == null) {
				System.out.println(book);
			}
		});
		

		System.out.println("Libros que contienen la cadena de caracteres");
		Book book = null;
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book bookToAnalyze = it.next(); 
			if ((bookToAnalyze.getTitle() != null && bookToAnalyze.getTitle().contains(filter)) ||
					(bookToAnalyze.getSummary() != null && bookToAnalyze.getSummary().contains(filter)) ||
					(bookToAnalyze.getAuthor() != null && bookToAnalyze.getAuthor().getBio() != null  &&  bookToAnalyze.getAuthor().getBio().contains(filter))) {
				//El libro cumple los parametros. Se comprueba si es mas reciente que el que ya existe, si es que este existe
				if (book == null) {
					book = bookToAnalyze;
				}else if (book.getPublicationTimestamp()==null) {
					book = bookToAnalyze;
				}else if (bookToAnalyze.getPublicationDate().after(book.getPublicationDate())) {
					book = bookToAnalyze;
				}
			}
		}

		books.sort(new BookComparator());

		
		BookDate bookDate = null;
		if (book != null) {
			bookDate = new BookDate(book); 
			System.out.println(bookDate);
			return Optional.of(bookDate);
		}

		return null;

		
	}
}
