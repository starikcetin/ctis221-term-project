package Products.Physical;

import Core.PhysicalProduct;
import ProductInfos.MovieInfo;

public class PhysicalMovie extends PhysicalProduct {

    private MovieInfo movieInfo;

    public PhysicalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
