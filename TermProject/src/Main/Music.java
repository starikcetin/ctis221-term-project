package Main;

public class Music extends Product {

    private final String album;
    private final String artist;
    private final String length;
    private final String producer;

    public Music(int productID, int releaseDate, double price, String productName, String publisher, String genre, String language, String type, String album, String artist, String length, String producer) {
        super(productID, releaseDate, price, productName, publisher, genre, language, type);
        this.album = album;
        this.artist = artist;
        this.length = length;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nArtist : " + artist
                + "\nAlbum : " + album
                + "\nProducer : " + producer
                + "\nLength : " + length;
    }
}
