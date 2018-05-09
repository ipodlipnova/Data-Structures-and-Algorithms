/**
 * Created by Asus on 03.02.2017.
 */
public class LinkedQueue {
    private int sz = 0;
    private Node begin, end;

    public void add(String s) {
        Node new_node = new Node(s);
        if (!isEmpty()) {
            new_node.prev = end;
            end.next = new_node;
            end = end.next;
        }
        else {
            begin = new_node;
            end = new_node;
        }
        sz++;
    }
    public void pop() {
        if (!isEmpty()) {
            begin = begin.next;
            sz--;
        }
    }
    public String first() {
        return begin.name;
    }

    public boolean isEmpty(){
        if (sz > 0)
            return false;
        return true;
    }
}
