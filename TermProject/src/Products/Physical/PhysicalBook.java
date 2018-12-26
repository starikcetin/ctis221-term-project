package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.BookInfo;
import Products.Infos.MovieInfo;
import Products.Interfaces.IBook;
import Products.ProductInfo;
import Products.ProductType;

public class PhysicalBook extends PhysicalProduct implements IBook {

    private BookInfo bookInfo;

    public PhysicalBook(BookInfo bookInfo) {
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
