import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i=1; i<N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        int[] parents = new int[N + 1];
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (parents[node] != neighbor) {
                    parents[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }

        for (int i=1; i<N; i++) {
            System.out.println(parents[i+1]);
        }
    }
}