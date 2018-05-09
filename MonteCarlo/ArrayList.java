import java.awt.geom.*;
/**
 * Created by Asus on 03.02.2017.
 */
public class ArrayList {
    public Point2D[] coordinates;
    public int size;

    private int n;

    ArrayList() {
        coordinates = new Point2D[1];
        size = 0;
        n = 1;
    }

    public void increase() {
        Point2D[] oldcoordinates = new Point2D[n];
        for (int i = 0; i < n; i++) {
            oldcoordinates[i] = coordinates[i];
        }
        coordinates = new Point2D[2 * n];
        for (int i = 0 ; i < n; i++) {
            coordinates[i] = oldcoordinates[i];
        }
        n *= 2;
    }

    public void add(Point2D x) {
        while (size >= n)
            increase();
        coordinates[size] = x;
        size++;
    }
}
