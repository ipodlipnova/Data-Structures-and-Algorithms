import java.text.NumberFormat;

/**
 * Created by Asus on 20.02.2e3 + 17.
 */
public class Main {

    public static int toMinutes(String a){
        String hours = "";
        String min = "";
        int minutes;
        for( int i = 0; i < a.indexOf(':'); i++)
            hours = hours + a.charAt(i);
        for( int i = a.indexOf(':') + 1; i < a.length(); i++)
            min = min + a.charAt(i);
        minutes = Integer.parseInt(hours) * 60 + Integer.parseInt(min);
        return minutes;
    }

    public static void main (String[] args) {
        Writer out = new Writer("output.txt");
        Reader.Init("input.txt");
        String s = Reader.readLine();
        String[] input = s.split(" ");
        s = Reader.readLine();
        int summ = (int) (Double.parseDouble(s) * 100);
        int[] time = new int[(input.length) / 2];
        int[] cost = new int[(input.length) / 2];
        boolean[] posTime = new boolean[summ + 1];
        int[] totalTime = new int[summ + 1];
        int a = 0, b = 0;
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                time[a] = toMinutes((input[i]));
                a++;
            } else {
                cost[b] = (int) (Double.parseDouble(input[i]) * 100);
                b++;
            }
        }
        int maximum = 0;
        posTime[0] = true; //finding optimal solution by dynamic programming
        for (int i = 0; i < time.length; i++)
            for (int j = posTime.length - 1; j >= 0; j--) {
                if (posTime[j] && (j + cost[i]) < totalTime.length) {
                    totalTime[j + cost[i]] = Math.max(totalTime[j + cost[i]], totalTime[j] + time[i]);
                    posTime[j + cost[i]] = true;
                }
            }
        for (int i = 0; i < totalTime.length; i++){
            if (totalTime[i] > maximum)
                maximum = totalTime[i];
        }
        out.write(Integer.toString(maximum));
        out.close();
    }
}