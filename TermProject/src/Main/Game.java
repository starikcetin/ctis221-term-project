package Main;

public class Game extends Product {

    private final String platforms;
    private final String engine;
    private final String developer;

    public Game(int productID, int releaseDate, double price, String productName, String publisher, String genre, String language, String type, String platforms, String engine, String developer) {
        super(productID, releaseDate, price, productName, publisher, genre, language, type);
        this.platforms = platforms;
        this.engine = engine;
        this.developer = developer;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPlatforms : " + platforms
                + "\nGame Engine : " + engine
                + "\nGame Developer : " + developer;

    }

}
