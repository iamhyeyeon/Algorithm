import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int ans = 0;
        int cnt = 0;

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                cnt++;
            } else {
                cnt--;
                if (input.charAt(i-1) == '(') {
                    ans += cnt;
                } else if (input.charAt(i-1) == ')') {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}