package Main;

import java.util.ArrayList;

public class ProductSystem {

    private static ArrayList<IProduct> products = new ArrayList<IProduct>();

    public static boolean addProduct(IProduct product) {
        for (IProduct it : products) {
            if (it.getProductId() == product.getProductId()) {
                return false;
            }
        }
        return products.add(product);
    }

    public static String displayProducts() {
        String result = "";

        for (IProduct it : products) {
            result += it.toString();
        }

        return result;
    }

    public static IProduct searchProduct(int productId) {
        for (IProduct it : products) {
            if (it.getProductId() == productId) {
                return it;
            }
        }

        return null;
    }

    public static IProduct deleteProduct(int productId) {
        for (IProduct it : products) {
            if (it.getProductId() == productId) {
                products.remove(it);
                return it;
            }
        }

        return null;
    }

    public static ArrayList<IProduct> getAllProducts() {
        return products;
    }
}