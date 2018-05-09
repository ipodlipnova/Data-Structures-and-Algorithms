import java.io.*;
import java.util.*;

/**
 * Created by Asus on 30.01.2017.
 */
public class Reader {
    static Scanner sc;
    static Scanner scan;
    public static void Init(String filename) {
        try {
            sc = new Scanner(new File(filename));
            scan = new Scanner(new File(filename));
        } catch (Exception ex) {
            return;
        }
    }

    public static String read() {
        try {
            String str = scan.nextLine();
            return str;
        } catch (Exception ex) {
            return "!";
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
