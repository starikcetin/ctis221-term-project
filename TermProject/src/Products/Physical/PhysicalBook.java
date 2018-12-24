package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.BookInfo;
import Products.ProductInfo;

public class PhysicalBook extends PhysicalProduct {

    private BookInfo bookInfo;

    public PhysicalBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
    
    @Override
    public ProductInfo getProductInfo() {
        return bookInfo;
    }
}
