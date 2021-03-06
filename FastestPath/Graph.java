import java.util.*;
import java.io.*;
/**
 * Created by Asus on 20.04.2017.
 */
public class Graph {

    final static double INF = Double.MAX_VALUE;
    static int size;
    static Edge values = new Edge();
    static Edge [][] edgeValue;
    static String [] vertices = new String[size];
    static HashMap<String, Integer> number = new HashMap<>();

    public static void setEdge(String begin, String end, Edge values){
        edgeValue[number.get(begin)][number.get(end)].distance = values.distance;
        edgeValue[number.get(begin)][number.get(end)].time = values.time;
        edgeValue[number.get(begin)][number.get(end)].cost = values.cost;
    }

    public static void deleteEdge(String begin, String end) {
        edgeValue[number.get(begin)][number.get(end)] = null;
    }

    static void Floyd(Edge [][] value) {
        for (int k = 0; k < size; k++)
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++){
                    double a = value[i][j].time;
                    value[i][j].time = Math.min(value[i][j].time, value[i][k].time + value[k][j].time);
                    if (value[i][j].time != a)
                        value[i][j].cost = value[i][k].cost + value[k][j].cost;
                }
    }

    public static void readUndirectedGraph(String filename)throws FileNotFoundException{
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        vertices = sc.nextLine().split(" ");
        size = vertices.length;
        edgeValue = new Edge[size][size];
        for (int i = 0; i < size; i++)
            for(int j = 0; j < size; j++){
                edgeValue[i][j] = new Edge();
                edgeValue[i][j].distance = INF;
                edgeValue[i][j].time = INF;
                edgeValue[i][j].cost = INF;
            }
        for (int i = 0; i < size; i++){
            vertices[i] = vertices[i].trim();
            number.put(vertices[i], i);
            edgeValue[i][i].distance = 0;
            edgeValue[i][i].time = 0;
            edgeValue[i][i].cost = 0;
        }
        while (sc.hasNext()) {
            String begin = sc.next().trim();
            String end = sc.next().trim();
            String [] input = sc.next().split(":");
            values.distance = Double.parseDouble(input[0].trim());
            values.time = Double.parseDouble(input[1].trim());
            values.cost = Double.parseDouble(input[2].trim());
            setEdge(begin, end, values);
            setEdge(end, begin, values);
        }
    }
}
