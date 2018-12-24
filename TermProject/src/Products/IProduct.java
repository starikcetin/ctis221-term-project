package Products;

import java.io.Serializable;

public interface IProduct extends Serializable {

    public int getProductId();

    public ProductInfo getProductInfo();

    public ProductType getProductType();

    public MediumType getMediumType();

    @Override
    public String toString();
}
