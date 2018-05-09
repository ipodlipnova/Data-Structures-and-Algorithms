import java.util.ArrayList;

/**
 * Created by Asus on 20.02.2e3+17.
 */
public class Sort {
    public static void sorting(ArrayList<Double> arr) {
        boolean swapped = true;
        int j = 0;
        double tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.size() - j; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    tmp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, tmp);
                    swapped = true;
                }
            }
        }
    }
}
