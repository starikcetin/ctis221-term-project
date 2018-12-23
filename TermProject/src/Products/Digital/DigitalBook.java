package Products.Digital;

import Core.DigitalProduct;
import ProductMetadata.BookInfo;

public class DigitalBook extends DigitalProduct {

    private BookInfo bookInfo;

    public DigitalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
