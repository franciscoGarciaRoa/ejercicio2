package com.pruebaTecnicaFJGR.ejercicio2.bean;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {

        if(null == book1) {
            return null == book2 ? 0 : 1;
        }
        else if(null == book2) {
            return -1;
        }
        
        if(null == book1.getPublicationDate()) {
        	if (null == book2.getPublicationDate()) {
        		if (null == book1.getAuthor() && null == book1.getAuthor().getBio()) {
        			if (null == book2.getAuthor() && null == book2.getAuthor().getBio()) {
        				return 0;
        			}else {
        				return 1;
        			}
        		}else {
        			if (null == book2.getAuthor() && null == book2.getAuthor().getBio()) {
        				return -1;
        			}else {
        				return book1.getAuthor().getBio().length() < book2.getAuthor().getBio().length() ? -1 : 1; 
        			}
        		}
        	}else {
        		return 1;
        	}
        	
        }
        else if(null == book2.getPublicationDate()) {
            return -1;
        }else {
        	return book1.getPublicationDate().after(book2.getPublicationDate()) ? -1 : 1;
        }
        
	}
	
}
