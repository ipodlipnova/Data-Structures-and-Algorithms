import java.util.HashMap;

/**
 * Created by Asus on 22.04.2017.
 */
public class Parser {
    static int cnt=0;
    static Edge edge;
    static HashMap<Character, Integer> numbers= new HashMap<>();

    public static boolean isNumber(char a){
        return (a >= '0' && a <= '9');
    }

    public static void parse(String s, Graph g){
        if (!s.contains("+") && !s.contains("*") ){ //case: char = number
            if (!numbers.containsKey(s.charAt(0))) {
                numbers.put(s.charAt(0), cnt);
                cnt++;
            }
            g.d[numbers.get(s.charAt(0))] = Integer.parseInt(s.substring(2, s.length()));

        }
        else if (isNumber(s.charAt(4))){ //case: char = char + number
            if (!numbers.containsKey(s.charAt(0))) {
                numbers.put(s.charAt(0), cnt);
                cnt++;
            }
            edge = new Edge();
            edge.operation = s.charAt(3);
            edge.destination = numbers.get(s.charAt(0));
            g.d[numbers.get(s.charAt(0))] = Integer.parseInt(s.substring(4, s.length()));
            if (!numbers.containsKey(s.charAt(2))) {
                numbers.put(s.charAt(2), cnt);
                cnt++;
            }
            g.addEdge(numbers.get(s.charAt(2)), edge);
            g.count[numbers.get(s.charAt(0))] = 1;
        }
        else { //case: char = char + char
            edge = new Edge();
            edge.operation = s.charAt(3);
            if (!numbers.containsKey(s.charAt(0))) {
                numbers.put(s.charAt(0), cnt);
                cnt++;
            }
            edge.destination = numbers.get(s.charAt(0));
            if (!numbers.containsKey(s.charAt(2))) {
                numbers.put(s.charAt(2), cnt);
                cnt++;
            }
            g.addEdge(numbers.get(s.charAt(2)), edge);
            if (!numbers.containsKey(s.charAt(4))) {
                numbers.put(s.charAt(4), cnt);
                cnt++;
            }
            g.addEdge(numbers.get(s.charAt(4)), edge);
            if (edge.operation == '*'){
                g.d[numbers.get(s.charAt(0))] = 1;
            }
            g.count[numbers.get(s.charAt(0))] = 2;
        }
    }
}
