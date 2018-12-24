package Products;

import java.io.Serializable;

public abstract class ProductInfo implements Serializable {

    protected String releaseDate;
    protected double price;
    protected String productName;

    // Publisher might be a company, so I am not making it of type Person.
    protected String publisher;

    protected String genre;
    protected String language;

    public ProductInfo(String releaseDate, double price, String productName, String publisher, String genre, String language) {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
