import java.util.*;

class Node {
    String node;
    Node left, right;

    public Node(String node) {
        this.node = node;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Node> tree = new HashMap<>();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String root = sc.next();
            String left = sc.next();
            String right = sc.next();

            //root 삽입
            tree.putIfAbsent(root, new Node(root));

            if (!".".equals(left)) {
                tree.putIfAbsent(left, new Node(left));
                tree.get(root).left = tree.get(left);
            }

            if (!".".equals(right)) {
                tree.putIfAbsent(right, new Node(right));
                tree.get(root).right = tree.get(right);
            }
        }

        Node root = tree.get("A"); // 루트 노드는 'A'라고 가정
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.node);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.node);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.node);
    }
}