import java.util.*;
import java.awt.geom.*;
/**
 * Created by Asus on 03.02.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Reader.Init("input.txt");
        String str = Reader.readLine();
        String result = String.format("%.2f", MonteCarlo.area(str));
        Writer out = new Writer("output.txt");
        out.write(result);
        out.close();
    }
}
