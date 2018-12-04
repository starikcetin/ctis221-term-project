package Main;

public class Movie extends Product{
    
    private final String producer;
    private final String director;
    private final String country;
    private final String starring;
    
    private final int length;
    private final double boxOffice;
    
    public Movie(int productID, int releaseDate, double price, String productName, String publisher, String genre, String language,String type,String producer, String director, String country, String starring,int length,double boxOffice) {
        super(productID, releaseDate, price, productName, publisher, genre, language,type);
        this.producer = producer;
        this.director = director;
        this.country = country;
        this.starring = starring;
        this.length = length;
        this.boxOffice = boxOffice;
        
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nProducer : "+producer+"\nDirector : "+director+"\nCountry : "+country+"\nStarring : "+starring+"\nTime : "+length+"\nBox Office : "+boxOffice;
        
    }
    
    
}
