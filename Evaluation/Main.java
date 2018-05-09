/**
 * Created by Asus on 03.02.2017.
 */
public class Main {
    static LinkedQueue tokens = new LinkedQueue();
    public static int new_pos(int i, String s){
        String double_token = s.charAt(i) + "";
        while (i+1<s.length() && (number(s.charAt(i+1)) || isPoint(s.charAt(i+1)))){
            double_token = double_token + s.charAt(i+1);
            i++;
        }
        tokens.add(double_token);
        return i;
    }

    public static boolean isPoint(char ch){
        if (ch == '.')
            return true;
        else
            return false;
    }

    public static boolean isSum (char ch) {
        if (ch == '+' || ch == '-')
            return true;
        else
            return false;
    }

    public static boolean isMult (char ch) {
        if (ch == '*' || ch == '/')
            return true;
        else
            return false;
    }

    public static boolean isBracets (char ch) {
        if (ch == '(' || ch == ')')
            return true;
        else
            return false;
    }

    public static boolean number(char ch) {
        if (ch>='0' && ch<='9')
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws Exception {
        Reader.Init("input.txt");
        String s = Reader.readLine();

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ')
                continue;
            else if (number(s.charAt(i)))
                i = new_pos(i, s);
            else
                tokens.add(s.charAt(i) + "");

        LinkedQueue queue = new LinkedQueue();
        LinkedStack stack = new LinkedStack();
        while (!(tokens.isEmpty())) {
            if (isSum(tokens.first().charAt(0)) || isMult(tokens.first().charAt(0)) || isBracets(tokens.first().charAt(0))) {
                if (isSum(tokens.first().charAt(0))) {
                    while ((!(stack.isEmpty())) && (!(stack.top()).equals("("))) {
                        queue.add(stack.top());
                        stack.pop();
                    }
                }
                else if (isMult(tokens.first().charAt(0))) {
                    while ((!(stack.isEmpty())) && (isMult(stack.top().charAt(0)))) {
                        queue.add(stack.top());
                        stack.pop();
                    }
                }
                else if ((tokens.first()).equals(")")) {
                    while (!(stack.top()).equals("(")) {
                        queue.add(stack.top());
                        stack.pop();
                    }
                    stack.pop();
                }
                if (!(tokens.first()).equals(")")) {
                    stack.add(tokens.first());
                }
            }
            else {
                queue.add(tokens.first());
            }
            tokens.pop();
        }

        while (!(stack.isEmpty()))
        {
            queue.add(stack.top());
            stack.pop();
        }
        LinkedStack RPN = new LinkedStack();

        RPN.add(queue.first());
        queue.pop();
        while (!queue.isEmpty()) {
            String cur = queue.first();
            queue.pop();
            if (isSum(cur.charAt(0))
                    || isMult(cur.charAt(0))) {
                Double second = Double.parseDouble(RPN.top());
                RPN.pop();
                Double first = Double.parseDouble(RPN.top());
                RPN.pop();

                if (cur.equals("+"))
                    RPN.add(Double.toString(second + first));
                if (cur.equals("-"))
                    RPN.add(Double.toString(first - second));
                if (cur.equals("*"))
                    RPN.add(Double.toString(second * first));
                if (cur.equals("/"))
                    RPN.add(Double.toString(first / second));
            }
            else {
                RPN.add(cur);
            }
        }
        Double answer = Double.parseDouble(RPN.top());
        String result = String.format("%.2f", answer);
        Writer out = new Writer ("output.txt");
        out.write(result);
        out.close();
    }
}
