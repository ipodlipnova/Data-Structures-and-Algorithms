/**
 * Created by Asus on 26.03.2017.
 */
public class Node {
    Node parent;
    Node left;
    Node right;
    double key;
    int height;
    int value;

    Node () {
        parent = null;
        left = null;
        right = null;
    }

    Node(double k, int v) {
        parent = null;
        left = null;
        right = null;
        key = k;
        height = 1;
        value = v;
    }
}
