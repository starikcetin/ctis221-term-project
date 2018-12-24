package Core;

import java.io.Serializable;

public abstract class Product implements IProduct, Serializable {

    private static int productIdCounter = -1;

    protected final int productId;

    public Product() {
        this.productId = nextProductId();
    }

    private static int nextProductId() {
        return ++productIdCounter;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "\nProduct ID: " + productId;
    }
}
