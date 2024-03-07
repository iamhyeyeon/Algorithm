import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer command;

        while(n-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");

            switch (command.nextToken()) {
                case "push":
                    queue.offer(Integer.valueOf(command.nextToken()));
                    break;
                case "pop":
                    Integer poll = queue.poll();
                    if (poll==null) poll = -1;
                    sb.append(poll).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    Integer front = queue.peek();
                    if (front == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(front).append("\n");
                    }
                    break;
                case "back":
                    Integer back = queue.peekLast();
                    if (back == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(back).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

}