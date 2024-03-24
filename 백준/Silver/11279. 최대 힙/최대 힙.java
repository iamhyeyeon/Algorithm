import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                Integer poll = queue.poll();
                if ((poll == null)) {
                    sb.append("0\n");
                } else {
                    sb.append(poll).append("\n");
                }
            } else {
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}