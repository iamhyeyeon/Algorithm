import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String postfix = br.readLine();
        Double[] arr = new Double[n];
        Stack<Double> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i=0; i<postfix.length(); i++) {
            if ('A'<=postfix.charAt(i) && 'Z'>=postfix.charAt(i)) {
                stack.push(arr[postfix.charAt(i) - 'A']);
            } else {
                if (!stack.isEmpty()) {
                    Double operand2 = stack.pop();
                    Double operand1 = stack.pop();
                    Double result = 0.0;
                    switch (postfix.charAt(i)) {
                        case '+':
                            result = operand1 + operand2;
                            break;
                        case '-':
                            result = operand1 - operand2;
                            break;
                        case '*':
                            result = operand1 * operand2;
                            break;
                        case '/':
                            result = operand1 / operand2;
                            break;
                    }
                    stack.push(result);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }

}