package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.MovieInfo;
import Products.ProductInfo;

public class PhysicalMovie extends PhysicalProduct {

    private MovieInfo movieInfo;

    public PhysicalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
    
    @Override
    public ProductInfo getProductInfo() {
        return movieInfo;
    }
}
