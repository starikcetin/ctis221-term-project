package Products.Digital;

import Core.DigitalProduct;
import ProductInfos.MovieInfo;

public class DigitalMovie extends DigitalProduct {

    private MovieInfo movieInfo;

    public DigitalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
