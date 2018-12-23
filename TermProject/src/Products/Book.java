package Products;

import Core.Product;
import ProductMetadata.BookInfo;

public class Book extends Product {

    private BookInfo bookInfo;

    public Book(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
