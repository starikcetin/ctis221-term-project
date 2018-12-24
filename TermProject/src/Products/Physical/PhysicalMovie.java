package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.MovieInfo;

public class PhysicalMovie extends PhysicalProduct {

    private MovieInfo movieInfo;

    public PhysicalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
