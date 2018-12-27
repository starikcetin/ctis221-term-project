package Products;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductSystem {

    private static final String SAVE_FILE_NAME = "products.bin";

    private static ArrayList<IProduct> products = new ArrayList<>();

    public static boolean addProduct(IProduct product) {
        for (IProduct it : products) {
            if (it.getProductId() == product.getProductId()) {
                return false;
            }
        }
        return products.add(product);
    }

    // Returns all products' toString(), 
    // concatenated with a blank line in between each one.
    public static String displayProducts() {
        String result = "";

        for (IProduct it : products) {
            result += it.toString() + "\n";
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

    // Returns the deleted item or null
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

    public static ArrayList<IProduct> getAllProducts(MediumType medium, ProductType type) {
        ArrayList<IProduct> result = new ArrayList<>();

        for (IProduct it : products) {
            if (it.getMediumType() == medium && it.getProductType() == type) {
                result.add(it);
            }
        }

        return result;
    }

    public static void saveAllToFile() throws FileNotFoundException, IOException {
        final File f = new File(SAVE_FILE_NAME);
        final FileOutputStream fos = new FileOutputStream(f);
        try (ObjectOutputStream output = new ObjectOutputStream(fos)) {
            output.writeObject(products);
        }
    }

    public static void readAllFromFile() throws IOException, ClassNotFoundException {
        final File f = new File(SAVE_FILE_NAME);

        // short-circuit if file is not there.
        if (!f.exists()) {
            return;
        }

        final FileInputStream fis = new FileInputStream(f);

        try (final ObjectInputStream input = new ObjectInputStream(fis)) {
            products = (ArrayList<IProduct>) input.readObject();
        }

        adaptStaticProductIdToArrayListMaxId();
    }

    private static void adaptStaticProductIdToArrayListMaxId() {
        int maxId = -1;

        for (IProduct it : products) {
            if (it.getProductId() > maxId) {
                maxId = it.getProductId();
            }
        }

        Product.setInitialId(maxId);
    }
}
