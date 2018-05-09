import java.io.*;
import java.util.*;

/**
 * Created by Asus on 30.01.2e3+17.
 */
public class Reader {
    static Scanner sc;
    public static void Init(String filename) {
        try {
            sc = new Scanner(new File(filename));
        } catch (Exception ex) {
            return;
        }
    }
    public static String readLine() {
        try {
            String str = sc.nextLine();
            return str;
        } catch (Exception ex) {
            return "!";
        }
    }
}
