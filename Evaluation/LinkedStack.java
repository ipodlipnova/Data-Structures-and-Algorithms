/**
 * Created by Asus on 03.02.2017.
 */
public class LinkedStack {
    private int sz = 0;
    private Node last;


    public void add(String s) {
        Node new_node = new Node(s);
        if (!isEmpty()) {
            new_node.prev = last;
            last.next = new_node;
            last = last.next;
        }
        else {
            last = new_node;
        }
        sz++;
    }
    public void pop() {
        if (!isEmpty()) {
            last = last.prev;
            sz--;
        }
    }
    public String top() {
        return last.name;
    }
    public boolean isEmpty(){
        if (sz > 0)
            return false;
        return true;
    }
}
