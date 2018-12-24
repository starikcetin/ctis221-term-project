package Products.Infos;

import Products.ProductInfo;
import Products.Person;
import java.util.ArrayList;

public class MovieInfo extends ProductInfo {

    // Producer might be a company, so I am not making it of type Person.
    private String producer;

    private Person director;
    private String country;
    private ArrayList<Person> starring;
    private int length;
    private double boxOffice;

    public MovieInfo(String producer, Person director, String country, ArrayList<Person> starring, int length, double boxOffice, String releaseDate, double price, String productName, String publisher, String genre, String language) {
        super(releaseDate, price, productName, publisher, genre, language);
        this.producer = producer;
        this.director = director;
        this.country = country;
        this.starring = starring;
        this.length = length;
        this.boxOffice = boxOffice;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nProducer: " + producer
                + "\nDirector: " + director
                + "\nCountry: " + country
                + "\nStarring: " + getStarringAsString()
                + "\nTime: " + length
                + "\nBox Office: " + boxOffice;
    }

    private String getStarringAsString() {
        String concated = "";

        for (Person it : starring) {
            concated += it.toString() + ", ";
        }

        // -2 is for removing the redundant comma and space at the end.
        return concated.substring(0, concated.length() - 2);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Person> getStarring() {
        return starring;
    }

    public void setStarring(ArrayList<Person> starring) {
        this.starring = starring;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }
}
