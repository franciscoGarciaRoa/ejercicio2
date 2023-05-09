package com.pruebaTecnicaFJGR.ejercicio2.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookDate extends Book {

	public String getPublicationDateStr() {
		if (getPublicationDate() != null) {
			SimpleDateFormat SDFormat= new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
			return SDFormat.format(new Date());
		}else {
			return "";
		}
	}

	@Override
	public String toString() {
		return "BookDate [PublicationDate=" + getPublicationDateStr() + ", Id=" + getId() + ", Title="
				+ getTitle() + ", Pages=" + getPages() + ", Summary=" + getSummary() + ", Author="
				+ getAuthor() + ", PublicationTimestamp=" + getPublicationTimestamp() + ", PublicationDate="
				+ getPublicationDate() + "]";
	}

	public BookDate(Book book) {
			super(book.getId(), book.getTitle(), book.getPages() , book.getSummary(), book.getAuthor(), book.getPublicationTimestamp());
	}
		
}
