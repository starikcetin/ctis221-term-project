package Main;

public abstract class Product implements IProduct {

    protected int productID;
    protected int releaseDate;
    protected double price;
    protected String productName;
    
    // Publisher might be a company, so I am not making it of type Person.
    protected String publisher;
    
    protected String genre;
    protected String language;
    protected String type;

    public Product(int productID, int releaseDate, double price, String productName, String publisher, String genre, String language, String type) {
        this.productID = productID;
        this.releaseDate = releaseDate;
        this.price = price;
        this.productName = productName;
        this.publisher = publisher;
        this.genre = genre;
        this.language = language;
        this.type = type;
    }

    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public String getProductType() {
        return type;
    }

    @Override
    public String toString() {
        return "\nID: " + productID
                + "\nName: " + productName
                + "\nPublisher: " + publisher
                + "\nGenre: " + genre
                + "\nRelease Date: " + releaseDate
                + "\nPrice: " + price
                + "\nLanguage: " + language;
    }
}
