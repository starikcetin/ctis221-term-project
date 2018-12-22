package Products;

import Core.Person;
import Core.Product;

public class Book extends Product {

    private int pageCount;
    private int isbn;
    private Person author;

    public Book(int releaseDate, double price, String productName, String publisher, String genre, String language, String type, int pageCount, int isbn, Person author) {
        super(releaseDate, price, productName, publisher, genre, language, type);

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
}
