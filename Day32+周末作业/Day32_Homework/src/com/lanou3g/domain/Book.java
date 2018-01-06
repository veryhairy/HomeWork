package com.lanou3g.domain;

public class Book {
    private String bkname;
    private String author;
    private String price;

    @Override
    public String toString() {
        return "Book{" +
                "bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Book() {

    }
}
