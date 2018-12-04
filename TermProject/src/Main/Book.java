package Main;

public class Book extends Product {

    private final int pageCount;
    private final int isbn;
    private final String author;

    public Book(int productID, int releaseDate, double price, String productName, String publisher, String genre, String language, String type, int pageCount, int isbn, String author) {
        super(productID, releaseDate, price, productName, publisher, genre, language, type);
        
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
