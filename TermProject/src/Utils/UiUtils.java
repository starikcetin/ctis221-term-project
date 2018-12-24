package Utils;

import Products.IProduct;
import Products.ProductInfo;

/**
 *
 * @author cetin
 */
public class UiUtils {

    public static String[] convertProductToRowItem(IProduct product) {
        ProductInfo pi = product.getProductInfo();
        return new String[]{
            pi.getProductName(),
            pi.getGenre(),
            pi.getLanguage(),
            pi.getPublisher(),
            pi.getReleaseDate(),
            Double.toString(pi.getPrice())
        };
    }

}
