/**
 * Created by Asus on 25.03.2017.
 */
public class AVLTreeMap {

    Node root = new Node();

    int height(Node p) {
        if (p == null)
            return 0;
        else
            return p.height;
    }

    int bfactor(Node p) {
        return height(p.right) - height(p.left);
    }

    void fixheight(Node p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = Math.max(hl, hr) + 1;
    }

    Node rotateright(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixheight(p);
        fixheight(q);
        return q;
    }

    Node rotateleft(Node q) {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixheight(q);
        fixheight(p);
        return p;
    }

    Node balance (Node p) {
        fixheight(p);
        if(bfactor(p) == 2) {
            if(bfactor(p.right) < 0)
                p.right = rotateright(p.right);
            return rotateleft(p);
        }
        if (bfactor(p) == -2) {
            if (bfactor(p.left) > 0)
                p.left = rotateleft(p.left);
            return rotateright(p);
        }
        return p;
    }

    void insert1(double k, int value) {
        root = insert(root, k, value);
    }

    Node insert(Node p, double k, int value) {
        if (p == null)
            return new Node(k, value);
        if (k < p.key)
            p.left = insert(p.left, k, value);
        else
            p.right = insert(p.right, k, value);
        return balance(p);
    }

    int search(double k) {
        Node p = root;
        while (p != null) {
            if (p.key > k)
                p = p.left;
            else if (p.key < k)
                p = p.right;
            else
                return p.value;
        }
        return 0;
    }
}
