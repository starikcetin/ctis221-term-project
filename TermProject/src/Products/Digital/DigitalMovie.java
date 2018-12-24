package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.MovieInfo;

public class DigitalMovie extends DigitalProduct {

    private MovieInfo movieInfo;

    public DigitalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
