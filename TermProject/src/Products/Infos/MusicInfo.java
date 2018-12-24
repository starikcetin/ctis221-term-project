package Products.Infos;

import Products.ProductInfo;
import Products.Person;

public class MusicInfo extends ProductInfo {

    private String album;
    private Person artist;
    private String length;

    // Producer might be a company, so I am not making it of type Person.
    private String producer;

    public MusicInfo(String album, Person artist, String length, String producer, String releaseDate, double price, String productName, String publisher, String genre, String language) {
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Person getArtist() {
        return artist;
    }

    public void setArtist(Person artist) {
        this.artist = artist;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    
    
}
