package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.BookInfo;
import Products.ProductInfo;

public class DigitalBook extends DigitalProduct {

    private BookInfo bookInfo;

    public DigitalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @Override
    public ProductInfo getProductInfo() {
        return bookInfo;
    }
}
