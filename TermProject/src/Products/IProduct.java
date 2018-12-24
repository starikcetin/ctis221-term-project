package Products;

import java.io.Serializable;

public interface IProduct extends Serializable {

    public int getProductId();
    
    public ProductInfo getProductInfo();

    @Override
    public String toString();
}
