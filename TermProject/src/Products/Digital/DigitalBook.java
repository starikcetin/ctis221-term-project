package Products.Digital;

import Products.DigitalProduct;
import ProductInfos.BookInfo;

public class DigitalBook extends DigitalProduct {

    private BookInfo bookInfo;

    public DigitalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
