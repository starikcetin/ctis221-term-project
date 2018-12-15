package Main;

public class Music extends Product {

    private String album;
    private Person artist;
    private String length;

    // Producer might be a company, so I am not making it of type Person.
    private String producer;

    public Music(int releaseDate, double price, String productName, String publisher, String genre, String language, String type, String album, Person artist, String length, String producer) {
        super(releaseDate, price, productName, publisher, genre, language, type);

        this.album = album;
        this.artist = artist;
        this.length = length;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nArtist: " + artist
                + "\nAlbum: " + album
                + "\nProducer: " + producer
                + "\nLength: " + length;
    }
}
