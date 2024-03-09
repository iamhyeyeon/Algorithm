import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer command;

        command = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(command.nextToken());
        int k = Integer.parseInt(command.nextToken());

        Deque<Integer> queue = new LinkedList<>();

        for (int i=0; i<n; i++) queue.offer(i+1);

        sb.append("<");
        while (queue.size() != 1) {
            for (int i=0; i<k-1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");

        System.out.println(sb);
        br.close();
    }

}