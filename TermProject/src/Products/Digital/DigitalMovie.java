package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.GameInfo;
import Products.Infos.MovieInfo;
import Products.Interfaces.IMovie;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalMovie extends DigitalProduct implements IMovie {

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
    
    @Override
    public void setProductInfo(ProductInfo newProductInfo) {
        movieInfo = (MovieInfo) newProductInfo;
    }
}
