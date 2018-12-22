package Products;

import Core.Product;
import Core.Person;

public class Game extends Product {

    private String platforms;
    private String engine;
    private Person developer;

    public Game(int releaseDate, double price, String productName, String publisher, String genre, String language, String type, String platforms, String engine, Person developer) {
        super(releaseDate, price, productName, publisher, genre, language, type);

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
