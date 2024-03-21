import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        int val = 1;

        String input = br.readLine();

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                val *= 2;
            } else if (c == '[') {
                stack.push(c);
                val *= 3;
            } else if (c == ')'){
                 if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                 } else if (input.charAt(i-1) == '(') {
                    res += val;
                 }
                stack.pop();
                val /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                } else if (input.charAt(i-1) == '[') {
                    res += val;
                }
                stack.pop();
                val /=3;
            }
        }
        if (!stack.isEmpty()) res = 0;
        System.out.println(res);
    }
}