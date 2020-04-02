package com.lucene.model;

public class Book {
	
	private int id;
	private String isdn;
	private String author;
	private String bookname;
	private String press;
	private double price;
	private int pages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsdn() {
		return isdn;
	}
	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Book(int id, String isdn, String author, String bookname, String press, double price, int pages) {
		super();
		this.id = id;
		this.isdn = isdn;
		this.author = author;
		this.bookname = bookname;
		this.press = press;
		this.price = price;
		this.pages = pages;
	}
	public Book(String isdn, String author, String bookname, String press, double price, int pages) {
		super();
		this.isdn = isdn;
		this.author = author;
		this.bookname = bookname;
		this.press = press;
		this.price = price;
		this.pages = pages;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isdn=" + isdn + ", author=" + author + ", bookname=" + bookname + ", press="
				+ press + ", price=" + price + ", pages=" + pages + "]";
	}
	
	
	
}
