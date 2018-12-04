package Main;

import java.util.ArrayList;

public class ProductManager {

    public static ArrayList<Product> products = new ArrayList<>();

    public static boolean addProduct(Product m) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == m.getProductID()) {
                return false;
            }
        }
        return products.add(m);
    }

    public static void removeProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == id) {
                products.remove(i);
            }
        }
    }

    public static Product searchProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Product> displayAllProduct() {
        return products;
    }
}
