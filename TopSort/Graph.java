import java.util.*;
/**
 * Created by Asus on 20.04.2017.
 */

class Graph {
    static private int V;
    public static LinkedList<Edge> adj[];
    public static int d [];
    public static int count [];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        d = new int[v];
        count = new int[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
            d[i] = 0;
            count[i] = 0;
        }
    }

    static void addEdge(int v, Edge w) {
        adj[v].add(w);
    }

    static void DFS(int v, boolean visited[], Stack stack) {
        visited[v] = true;
        Edge i;

        Iterator<Edge> it = adj[v].iterator();

        while (it.hasNext()) {
            i = it.next();
            if (!visited[i.destination])
                DFS(i.destination, visited, stack);
        }

        stack.push(new Integer(v));
    }

    static Stack topologicalSort() {
        Stack stack = new Stack();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                DFS(i, visited, stack);
        return stack;
    }
}