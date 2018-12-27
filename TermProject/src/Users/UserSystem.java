package Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserSystem {

    private static final String SAVE_FILE_NAME = "users.bin";
    private static User loggedInUser;

    private static ArrayList<User> users = new ArrayList<User>();

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
        int a = 1;
    }

    // returns false if there is a username collision, 
    //true if added successfully
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
    public static void readAllFromFile() throws IOException, ClassNotFoundException {
        final File f = new File(SAVE_FILE_NAME);

        // short-circuit if file is not there.
        if (!f.exists()) {
            return;
        }

        final FileInputStream fis = new FileInputStream(f);
        try (final ObjectInputStream input = new ObjectInputStream(fis)) {
            users = (ArrayList<User>) input.readObject();
        }
    }

    // writes all the info in arrayList to save file.
    public static void writeAllToFile() throws IOException {
        final File f = new File(SAVE_FILE_NAME);
        final FileOutputStream fos = new FileOutputStream(f);
        try (final ObjectOutputStream output = new ObjectOutputStream(fos)) {
            output.writeObject(users);
        }
    }
}
