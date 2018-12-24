package Products.Infos;

import Products.ProductInfo;
import Products.Person;

public class GameInfo extends ProductInfo {

    private String platforms;
    private String engine;
    private Person developer;

    public GameInfo(String platforms, String engine, Person developer, String releaseDate, double price, String productName, String publisher, String genre, String language) {
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

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Person getDeveloper() {
        return developer;
    }

    public void setDeveloper(Person developer) {
        this.developer = developer;
    }
    
    
}
