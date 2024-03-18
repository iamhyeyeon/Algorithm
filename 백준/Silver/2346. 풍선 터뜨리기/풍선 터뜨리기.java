import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Balloon> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());

        for (int i=1; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            queue.offer(new Balloon(i+1, num));
        }

        sb.append("1").append("\n");
        while (!queue.isEmpty()) {
            if (first>0) {
                for (int j=1; j<first; j++) {
                    queue.offer(queue.poll());
                }
                Balloon poll = queue.poll();
                first = poll.numValue;
                sb.append(poll.index).append("\n");
            } else {
                for (int j=1; j<-first; j++) {
                    queue.addFirst(queue.pollLast());
                }
                Balloon balloon = queue.pollLast();
                first = balloon.numValue;
                sb.append(balloon.index).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class Balloon{
    int index;
    int numValue;

    public Balloon(int index, int numValue) {
        this.index = index;
        this.numValue = numValue;
    }
}