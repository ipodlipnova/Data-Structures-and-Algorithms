import java.util.ArrayList;

/**
 * Created by Asus on 20.02.2e3+17.
 */
public class Main {
    public static void main(String[] args) {
        Reader.Init("input.csv");
        Writer out = new Writer("output.txt");

        int counter = 0;
        String ans = "";
        ArrayList<Double>[] column = null;
        boolean init = false;
        while (Reader.sc.hasNext()) {
            String s = Reader.readLine();
            String [] str = s.split(",");
            if (!init) {//Count arraylist size, initialization
                column = new ArrayList[str.length];
                for (int i = 0; i < str.length; i++) {
                    column[i] = new ArrayList<Double>();
                }
                init = true;
            }
            for (int i = 0; i < str.length; i++) {
                column[i].add(Double.parseDouble(str[i]));
            }
        }
        for (int i = 0; i < column.length; i++) {
            Sort.sorting(column[i]);
            counter = 0;
            for (int j = 0; j < column[i].size() - 2; j++) {
                double dif1 = column[i].get(j + 1) - column[i].get(j);
                double dif2 = column[i].get(j + 2) - column[i].get(j + 1);
                if ((Math.abs(dif1 - dif2) < 1e-4) && (dif1 != 0.0) && (dif2 != 0.0)) {
                    counter++;
                }
            }
            if (counter == (column[i].size() - 2)) {
                ans = ans + Integer.toString(i);
                break;
            }
        }
        out.write(ans);
        out.close();
    }
}