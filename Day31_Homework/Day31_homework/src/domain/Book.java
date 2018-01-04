package domain;

public class Book {
    private String bkname;
    private String author;
    private  long price;

    @Override
    public String toString() {
        return "Book{" +
                "bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public Book() {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
