import java.util.*;
import java.io.*;
/**
 * Created by Asus on 30.01.2017.
 */
public class Main {

    public static void main(String[] args) {
        String result = "";
        Reader.Init("input.txt");
        String s = Reader.readLine();
        NaiveBitset bitset = new NaiveBitset();
        if (s.length() > 0) {
            String[] input = s.split(" ");
            for (int i = 0; i < input.length; i++) {
                int n = Integer.parseInt(input[i]);
                bitset.add(n);
            }
        }
        String comp = Reader.readLine();
        System.out.println(comp);
        if (comp.length() > 0) {
            String[] compare = comp.split(" ");
            for (int i = 0; i < compare.length; i++) {
                int n = Integer.parseInt(compare[i]);
                if (bitset.has(n))
                    result += "true ";
                else
                    result += "false ";
            }
        }
        Writer out = new Writer("output.txt");
        if (result.length()>0)
            out.write(result.substring(0, result.length() - 1));
        else
            out.write("");
        out.close();
    }
}