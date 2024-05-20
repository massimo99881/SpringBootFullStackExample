package edu.quintainfo.dtos;

import java.math.BigDecimal;

public class BookAuthorDto {
	
	// Book variable
	private String title;
	private String genre;
	private BigDecimal price; 
	
	// Author variable
	private Integer authorId;

	public BookAuthorDto() {
	}

	public BookAuthorDto(String title, String genre, BigDecimal price, Integer authorId) {
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "BookAuthorDto [title=" + title + ", genre=" + genre + ", price=" + price + ", authorId=" + authorId
				+ "]";
	}

}
