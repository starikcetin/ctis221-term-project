package Products.Infos;

import Products.ProductInfo;
import Products.Person;

public class BookInfo extends ProductInfo {

    private int pageCount;
    private int isbn;
    private Person author;

    public BookInfo(int pageCount, int isbn, Person author, String releaseDate, double price, String productName, String publisher, String genre, String language) {
        super(releaseDate, price, productName, publisher, genre, language);
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nISBN: " + isbn
                + "\nAuthor: " + author
                + "\nPage Count: " + pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }
}
