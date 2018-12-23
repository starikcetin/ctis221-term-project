package Products.Physical;

import Core.PhysicalProduct;
import ProductMetadata.MovieInfo;

public class PhysicalMovie extends PhysicalProduct {

    private MovieInfo movieInfo;

    public PhysicalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
