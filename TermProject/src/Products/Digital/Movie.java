package Products.Digital;

import Core.Product;
import ProductMetadata.MovieInfo;

public class Movie extends Product {

    private MovieInfo movieInfo;

    public Movie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
