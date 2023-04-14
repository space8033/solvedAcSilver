package node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1991 {
    static Node head = new Node("A", null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            make(head, parent, left, right);
        }

        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        post(head);
    }

    static class Node {
        String parent;
        Node left;
        Node right;

        Node(String parent, Node left, Node right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public static void make(Node temp, String root, String left, String right) {
        if(temp.parent.equals(root)) {
            if(left.equals(".")) {
                temp.left = null;
            }else {
                temp.left = new Node(left, null, null);
            }
            if(right.equals(".")) {
                temp.right = null;
            }else {
                temp.right = new Node(right, null, null);
            }
        }else {
            if(temp.left != null) {
                make(temp.left, root, left, right);
            }
            if(temp.right != null) {
                make(temp.right, root, left, right);
            }
        }
    }

    public static void pre(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.parent);
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node node) {
        if(node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.parent);
        in(node.right);
    }

    public static void post(Node node) {
        if(node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.parent);
    }
}
