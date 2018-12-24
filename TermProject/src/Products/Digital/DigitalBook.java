package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.BookInfo;

public class DigitalBook extends DigitalProduct {

    private BookInfo bookInfo;

    public DigitalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
