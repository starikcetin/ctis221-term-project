package Products.Physical;

import Core.PhysicalProduct;
import ProductMetadata.BookInfo;

public class PhysicalBook extends PhysicalProduct {

    private BookInfo bookInfo;

    public PhysicalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
