/**
 * Created by Asus on 05.02.2017.
 */
class Node {
    String name;
    Node next, prev;

    Node() {
        name = "";
        next = null;
        prev = null;
    }

    Node(String s) {
        name = s;
        next = null;
        prev = null;
    }

}