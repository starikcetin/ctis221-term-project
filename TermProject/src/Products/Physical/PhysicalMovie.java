package Products.Physical;

import Products.Infos.GameInfo;
import Products.PhysicalProduct;
import Products.Infos.MovieInfo;
import Products.Interfaces.IMovie;
import Products.ProductInfo;
import Products.ProductType;

public class PhysicalMovie extends PhysicalProduct implements IMovie {

    private MovieInfo movieInfo;

    public PhysicalMovie(MovieInfo movieInfo) {
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
    public void updateProductInfo(ProductInfo newProductInfo) {
        movieInfo = (MovieInfo) newProductInfo;
    }
}
