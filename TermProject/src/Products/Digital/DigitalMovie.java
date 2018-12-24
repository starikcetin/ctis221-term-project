package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.MovieInfo;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalMovie extends DigitalProduct {

    private MovieInfo movieInfo;

    public DigitalMovie(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    @Override
    public ProductInfo getProductInfo() {
        return movieInfo;
    }

    @Override
    public ProductType getProductType() {
        return ProductType.Movie;
    }
}
