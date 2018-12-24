package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.BookInfo;

public class PhysicalBook extends PhysicalProduct {

    private BookInfo bookInfo;

    public PhysicalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
