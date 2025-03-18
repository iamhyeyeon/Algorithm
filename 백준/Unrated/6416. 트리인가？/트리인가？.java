import java.util.*;

public class Main {

    static int caseNumber = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> inDegree = new HashMap<>(); // 노드로 들어오는 간선의 수
            Set<Integer> nodes = new HashSet<>();

            while (true) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                if (u < 0 && v < 0) return; // 종료 조건
                if (u == 0 && v == 0) break; // 테스트 케이스 종료

                graph.putIfAbsent(u, new ArrayList<>());
                graph.get(u).add(v);
                nodes.add(u);
                nodes.add(v);

                inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
                inDegree.putIfAbsent(u, 0);
            }

            if (isTree(graph, nodes, inDegree)) {
                System.out.println("Case " + caseNumber + " is a tree.");
            } else {
                System.out.println("Case " + caseNumber + " is not a tree.");
            }
            caseNumber++;
        }
    }

    static boolean isTree(Map<Integer, List<Integer>> graph, Set<Integer> nodes, Map<Integer, Integer> inDegree) {
        if (nodes.isEmpty()) return true; // 빈 그래프는 트리

        // 루트 노드 찾기 (들어오는 간선이 없는 노드가 하나여야 함)
        int root = -1;
        for (int node : nodes) {
            if (inDegree.get(node) == 0) {
                if (root == -1) root = node;
                else return false; // 루트가 여러 개면 트리가 아님
            }
        }
        if (root == -1) return false; // 루트가 없으면 트리가 아님

        // 트리의 간선 개수 조건 확인 (간선 수 == 노드 수 - 1)
        int edgeCount = graph.values().stream().mapToInt(List::size).sum();
        if (edgeCount != nodes.size() - 1) return false;

        return true;
    }
}