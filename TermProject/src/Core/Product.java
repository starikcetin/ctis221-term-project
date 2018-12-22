package Core;

public abstract class Product implements IProduct {

    private static int productIdCounter = -1;

    protected final int productId;

    protected int releaseDate;
    protected double price;
    protected String productName;

    // Publisher might be a company, so I am not making it of type Person.
    protected String publisher;

    protected String genre;
    protected String language;
    protected String type;

    public Product(int releaseDate, double price, String productName, String publisher, String genre, String language, String type) {
        this.productId = nextProductId();

        this.releaseDate = releaseDate;
        this.price = price;
        this.productName = productName;
        this.publisher = publisher;
        this.genre = genre;
        this.language = language;
        this.type = type;
    }

    private static int nextProductId() {
        return ++productIdCounter;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getProductType() {
        return type;
    }

    @Override
    public String toString() {
        return "\nProduct ID: " + productId
                + "\nName: " + productName
                + "\nPublisher: " + publisher
                + "\nGenre: " + genre
                + "\nRelease Date: " + releaseDate
                + "\nPrice: " + price
                + "\nLanguage: " + language;
    }
}
