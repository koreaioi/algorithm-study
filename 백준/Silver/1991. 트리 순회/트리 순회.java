
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://acmicpc.net/problem/1991
 *
 */
public class Main {

    public static int N;
    public static Node[] nodes;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node((char) ('A' + i));
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            Node node = nodes[c - 'A'];

            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left != '.') node.left = nodes[left - 'A'];
            if(right != '.') node.right = nodes[right - 'A'];
        }

        // 중위 순회.
        middle(nodes[0]);
        sb.append("\n");

        // 전위 순회.
        front(nodes[0]);
        sb.append("\n");

        back(nodes[0]);
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public static void middle(Node root) {
        if(root == null) return;

        sb.append(root.value);
        middle(root.left);
        middle(root.right);
    }

    public static void front(Node root) {
        // 종료 조건
        if (root == null) {
            return;
        }

        front(root.left);
        sb.append(root.value);
        front(root.right);
    }

    public static void back(Node root) {
        if (root == null) {
            return;
        }

        back(root.left);
        back(root.right);
        sb.append(root.value);

    }


    public static class Node {
        public Node left;
        public Node right;
        char value;
        public Node(char value) {
            this.value = value;
        }
    }

}
