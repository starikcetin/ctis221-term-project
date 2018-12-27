package Users;

import Products.IProduct;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String name;
    private String surname;
    private String email;
    private String username;
    private char[] password;
    private boolean isAdmin;

    private ArrayList<IProduct> purchaseHistory;

    public User(String name, String surname, String email, String username, char[] password, boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        
        this.purchaseHistory = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{"
                + "name=" + name
                + ", surname=" + surname
                + ", email=" + email
                + ", username=" + username
                + ", password=" + password
                + ", isAdmin=" + Boolean.toString(isAdmin)
                + '}';
    }

    public String toStringForFile() {
        return name + " " + surname + " " + email + " " + username + " " + String.valueOf(password) + " " + isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public ArrayList<IProduct> getPurchaseHistory() {
        return purchaseHistory;
    }
    
    public void registerPurchasedProduct(IProduct product) {
        purchaseHistory.add(product);
    }
}
