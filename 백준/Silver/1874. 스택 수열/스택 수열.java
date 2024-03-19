import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        while (n-- > 0) {
            int val = Integer.parseInt(br.readLine());

            if (val > start) {
                for (int i=start+1; i<=val; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                start=val;
            } else if (stack.peek() != val) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}