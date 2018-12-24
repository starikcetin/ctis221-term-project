package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.BookInfo;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalBook extends DigitalProduct {

    private BookInfo bookInfo;

    public DigitalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @Override
    public ProductInfo getProductInfo() {
        return bookInfo;
    }

    @Override
    public ProductType getProductType() {
        return ProductType.Book;
    }
}
