import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Created by Asus on 05.02.2017.
 */
public class MonteCarlo {
    static final double N = 1e6 + 10;
    static double minimumX = N, minimumY = N, maximumX = -N, maximumY = -N;

    public static boolean intersects(Point2D a, Point2D b, Point2D c, Point2D d) {
        double[][] A = new double[2][2];
        A[0][0] = b.getX() - a.getX();
        A[1][0] = b.getY() - a.getY();
        A[0][1] = c.getX() - d.getX();
        A[1][1] = c.getY() - d.getY();

        double det0 = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        double detU = (c.getX() - a.getX()) * A[1][1] - (c.getY() - a.getY()) * A[0][1];
        double detV = A[0][0] * (c.getY() - a.getY()) - A[1][0] * (c.getX() - a.getX());

        double u = detU / det0;
        double v = detV / det0;
        return u > 0 && u < 1 && v > 0 && v < 1;
    }

    public static void newcoordinates(double x, double y) {
        if (minimumX > x)
            minimumX = x;
        if (maximumX < x)
            maximumX = x;
        if (minimumY > y)
            minimumY = y;
        if (maximumY < y)
            maximumY = y;
    }

    public static double area(String str){
        Point2D.Double point = new Point2D.Double(0.0, 0.0);
        Point2D.Double p = new Point2D.Double(0.0, 0.0);
        String[] points = str.split(" ");
        ArrayList arr = new ArrayList();

        double x = 0.0, y = 0.0;
        for (int i=0; i<points.length; i+=2) {
            x = Double.parseDouble(points[i]);
            y = Double.parseDouble(points[i+1]);
            p = new Point2D.Double(x, y);
            arr.add(p);
            MonteCarlo.newcoordinates(x, y);
        }
        p = new Point2D.Double(arr.coordinates[0].getX(), arr.coordinates[0].getY());
        arr.add(p);
        double P = 0.0, last = 0.0;
        double inside = 0.0, all = 0.0;
        Random random = new Random();
        point = new Point2D.Double(MonteCarlo.minimumX - 2.7, (MonteCarlo.minimumY + MonteCarlo.maximumY) / 2.7);
        int index = 0;
        int inter = 0;
        while (true) {
            index++;
            inter = 0;
            double x1 = random.nextDouble();
            double y1 = random.nextDouble();
            while (x1 == 1.0 || x1 == 0.0)
                x1 = random.nextDouble();
            while (y1 == 1.0 || y1 == 0.0)
                y1 = random.nextDouble();

            x1 = x1 * (MonteCarlo.maximumX - MonteCarlo.minimumX) + MonteCarlo.minimumX;
            y1 = y1 * (MonteCarlo.maximumY - MonteCarlo.minimumY) + MonteCarlo.minimumY;

            Point2D.Double p1 = new Point2D.Double(x1, y1);
            for (int i = 1; i < arr.size; i++) {
                if (MonteCarlo.intersects(arr.coordinates[i - 1], arr.coordinates[i], p1, point))
                    inter++;
            }
            if (inter % 2 == 1)
                inside++;
            all++;
            P = (inside / all);
            double diff = P-last;
            if (diff<0)
                diff*=-1;
            if (index > (int)1e6 && diff * (MonteCarlo.maximumX - MonteCarlo.minimumX) * (MonteCarlo.maximumY - MonteCarlo.minimumY) < 1e-6) {
                break;
            }
            last = P;
        }
        double answer = (MonteCarlo.maximumX - MonteCarlo.minimumX) * (MonteCarlo.maximumY - MonteCarlo.minimumY) * P;
        return answer;
    }
}
