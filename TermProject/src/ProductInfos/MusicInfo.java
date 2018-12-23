package ProductInfos;

import Core.ProductInfo;
import Core.Person;

public class MusicInfo extends ProductInfo {

    private String album;
    private Person artist;
    private String length;

    // Producer might be a company, so I am not making it of type Person.
    private String producer;

    public MusicInfo(String album, Person artist, String length, String producer, int releaseDate, double price, String productName, String publisher, String genre, String language) {
        super(releaseDate, price, productName, publisher, genre, language);
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
