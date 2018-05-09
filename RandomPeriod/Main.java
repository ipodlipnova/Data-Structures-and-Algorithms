/**
 * Created by Asus on 25.03.2017.
 */
public class Main {
    public static int solution() {
        AVLTreeMap map = new AVLTreeMap();
        int step = 1;
        Reader.Init("input.txt");
        long seed = Long.parseLong(Reader.readLine());
        MyRandom random = new MyRandom(seed);
        while (true) {
            double current = random.nextDouble();
            if (map.search(current) != 0) {
                return seed != current ? (step - map.search(current)) : 1;
            }
            else {
                map.insert1(current, step);
            }
            step++;
        }
    }
    public static void main(String[] agrs) {
        Writer out = new Writer("output.txt");
        out.write(Integer.toString(solution()));
        out.close();
    }
}