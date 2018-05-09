import java.io.*;

/**
 * Created by Asus on 20.04.2017.
 */
public class Main {

    public static double round(double a){
        a = a * 10;
        int i = (int)Math.round(a);
        return (double)i/10;
    }

    public static void solution() throws FileNotFoundException{
        Reader.Init("input.txt");
        Writer out = new Writer("output.txt");
        while (Reader.sc.hasNext()) {
            String s = Reader.readLine();
            String[] input = s.split(" ");
            double weight = Double.parseDouble(input[2]);
            Graph.readUndirectedGraph("russia.txt");
            Graph.Floyd(Graph.edgeValue);
            if (!Reader.sc.hasNext())
                out.write(input[0] + " " + input[1] + " " + round(weight) + " " +round(Graph.edgeValue[Graph.number.get(input[0])][Graph.number.get(input[1])].time) + " " + round(weight*Graph.edgeValue[Graph.number.get(input[0])][Graph.number.get(input[1])].cost));
            else
                out.write(input[0] + " " + input[1] + " " + round(weight) + " " +round(Graph.edgeValue[Graph.number.get(input[0])][Graph.number.get(input[1])].time) + " " + round(weight*Graph.edgeValue[Graph.number.get(input[0])][Graph.number.get(input[1])].cost) + "\n");
        }
        out.close();
    }

    public static void main(String[] args) throws Exception{
        solution();
    }
}
