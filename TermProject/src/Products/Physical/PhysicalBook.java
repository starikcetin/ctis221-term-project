package Products.Physical;

import Core.PhysicalProduct;
import ProductInfos.BookInfo;

public class PhysicalBook extends PhysicalProduct {

    private BookInfo bookInfo;

    public PhysicalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
