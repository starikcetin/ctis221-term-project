package ProductInfos;

import Products.ProductInfo;
import Products.Person;

public class GameInfo extends ProductInfo {

    private String platforms;
    private String engine;
    private Person developer;

    public GameInfo(String platforms, String engine, Person developer, int releaseDate, double price, String productName, String publisher, String genre, String language) {
        super(releaseDate, price, productName, publisher, genre, language);
        this.platforms = platforms;
        this.engine = engine;
        this.developer = developer;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPlatforms: " + platforms
                + "\nEngine: " + engine
                + "\nDeveloper: " + developer;
    }
}
