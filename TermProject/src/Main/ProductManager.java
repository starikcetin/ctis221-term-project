package Main;

import java.util.ArrayList;

public class ProductManager {

    public static ArrayList<Product> products = new ArrayList<>();

    public static boolean addProduct(Product product) {
        for (Product it : products) {
            if (it.getProductID() == product.getProductID()) {
                return false;
            }
        }
        return products.add(product);
    }

    public static void removeProduct(int productId) {
        for (Product it : products) {
            if (it.getProductID() == productId) {
                products.remove(it);
            }
        }
    }
    public static boolean editProduct(Product m) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == m.getProductID()) {
                /*implement edit product codes*/
                return true;
            }
        }
        return false;
    }

    public static Product searchProduct(int id) {
        for (Product it : products) {
            if (it.getProductID() == id) {
                return it;
            }
        }
        return null;
    }

    public static ArrayList<Product> getAllProducts() {
        return products;
    }
}
