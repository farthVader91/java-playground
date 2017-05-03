import java.util.*;

public class BSTree {

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Node> inorder(Node root) {
        ArrayList<Node> l = new ArrayList<Node>();
        if (root == null)
            return l;
        for(Node n: inorder(root.left))
            l.add(n);
        l.add(root);
        for(Node n: inorder(root.right))
            l.add(n);
        return l;
    }

    public static Node kthSmallest(Node root, int k) {
        Stack<Node> s = new Stack<Node>();
        Node cur = root;
        while(cur != null) {
            s.push(cur);
            cur = cur.left;
        }
        int i = 0;
        while(!s.isEmpty()) {
            cur = s.pop();
            if (++i == k) break;
            cur = cur.right;
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
        }
        if (i != k) cur = null;

        return cur;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        System.out.println(kthSmallest(root, 7).data);
    }
}
