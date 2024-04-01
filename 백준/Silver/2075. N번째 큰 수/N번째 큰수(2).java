import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>();

        Integer n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            queue.offer(Integer.valueOf(st.nextToken()));
        }

        for (int j=0; j<n-1; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i=0; i<n; i++) {
                Integer val = Integer.valueOf(st.nextToken());
                if (queue.peek() < val) {
                    queue.poll();
                    queue.offer(val);
                }
            }
        }

        System.out.println(queue.poll());
    }
}
