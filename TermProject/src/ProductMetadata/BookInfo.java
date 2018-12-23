package ProductMetadata;

import Core.Person;

public class BookInfo extends ProductInfo {

    private int pageCount;
    private int isbn;
    private Person author;

    public BookInfo(int pageCount, int isbn, Person author, int releaseDate, double price, String productName, String publisher, String genre, String language) {
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
}
