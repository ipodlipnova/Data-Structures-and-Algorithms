import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Asus on 22.04.2017.
 */
public class Main {

    static Graph g;
    static Stack stack;

    public static void solution(){
        Reader.Init("input.txt");
        Writer out = new Writer("output.txt");
        int amount = 0;
        while (Reader.scan.hasNextLine()){
            Reader.read();
            amount++;
        }
        g = new Graph(amount);
        while (Reader.sc.hasNext()) {
            String s = Reader.readLine();
            Parser.parse(s, g);
        }
        stack = Graph.topologicalSort();
        while (!stack.isEmpty()) {
            int v = (int)stack.pop();
            if (g.count[v] == 0){
                Iterator<Edge> it = g.adj[v].iterator();
                while (it.hasNext()) {
                    Edge i = it.next();
                    if (i.operation == '*')
                        g.d[i.destination] *= g.d[v];
                    else
                        g.d[i.destination] += g.d[v];
                    g.count[i.destination]--;
                }
            }
        }
        if (g.count[Parser.numbers.get('R')] == 0)
            out.write(Integer.toString(g.d[Parser.numbers.get('R')]));
        else
            out.write("ERROR");
        out.close();
    }


    public static void main(String [] args) {
        solution();
    }
}
