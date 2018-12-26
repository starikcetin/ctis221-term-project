package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.BookInfo;
import Products.Interfaces.IBook;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalBook extends DigitalProduct implements IBook {

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

    @Override
    public void setProductInfo(ProductInfo newProductInfo) {
        bookInfo = (BookInfo) newProductInfo;
    }
}
