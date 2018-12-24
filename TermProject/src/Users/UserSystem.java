package Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSystem {

    private static final String SAVE_FILE_NAME = "usersinfo.txt";
    private static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }
    private static ArrayList<User> users = new ArrayList<User>();

    // returns false if there is a username collision, 
    //true if added successfully
    
    public static void setLoggedInUser(User user){
        loggedInUser=user;
    }
    
    public static boolean addUser(User newUser) {
        for (User it : users) {
            if (it.getUsername().compareTo(newUser.getUsername()) == 0) {
                return false;
            }
        }

        users.add(newUser);
        return true;
    }

    
    // returns the user if found, otherwise null
    public static User findUser(String username) {
        for (User it : users) {
            if (it.getUsername().compareTo(username) == 0) {
                return it;
            }
        }

        return null;
    }

    // return the user removed, if no suitale user is found returns null
    public static User removeUser(String username) {
        for (User it : users) {
            if (it.getUsername().compareTo(username) == 0) {
                users.remove(it);
                return it;
            }
        }

        return null;
    }

    // reads all the user info from save file and reconstructs the arrayList.
    public static void readAllFromFile() throws FileNotFoundException {
        File f = new File(SAVE_FILE_NAME);
        
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        
        try (Scanner sc = new Scanner(f)) {
            users.clear();
            
            while (sc.hasNext()) {
                String name = sc.next();
                String surname = sc.next();
                String email = sc.next();
                String username = sc.next();
                String password = sc.next();
                Boolean isAdmin = sc.nextBoolean();
                
                User readUser = new User(name, surname, email, username, password.toCharArray(), isAdmin);
                users.add(readUser);
            }
        }
    }

    // writes all the info in arrayList to save file.
    public static void writeAllToFile() throws IOException {
        File f = new File(SAVE_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(f)) {
            pw.print("");
            
            for (User it : users) {
                pw.append(it.toStringForFile());
                pw.append("\r\n");
            }
        }
    }

    public static String getSAVE_FILE_NAME() {
        return SAVE_FILE_NAME;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    
    
}
