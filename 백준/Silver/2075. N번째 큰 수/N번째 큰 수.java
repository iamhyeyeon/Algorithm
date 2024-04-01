import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        Integer n = Integer.valueOf(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                queue.offer(Integer.valueOf(st.nextToken()));
            }
        }

        while (n-- > 1) queue.poll();

        System.out.println(queue.poll());
    }
}