package Products;

import java.io.Serializable;

public interface IProduct extends Serializable {

    public int getProductId();

    @Override
    public String toString();
}
