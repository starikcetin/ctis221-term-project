package ProductMetadata;

public abstract class ProductInfo {

    protected int releaseDate;
    protected double price;
    protected String productName;

    // Publisher might be a company, so I am not making it of type Person.
    protected String publisher;

    protected String genre;
    protected String language;

    public ProductInfo(int releaseDate, double price, String productName, String publisher, String genre, String language) {
        this.releaseDate = releaseDate;
        this.price = price;
        this.productName = productName;
        this.publisher = publisher;
        this.genre = genre;
        this.language = language;
    }

    @Override
    public String toString() {
        return "ProductInfo"
                + "\nName: " + productName
                + "\nPublisher: " + publisher
                + "\nGenre: " + genre
                + "\nRelease Date: " + releaseDate
                + "\nPrice: " + price
                + "\nLanguage: " + language;
    }
}
