import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0 || num == 1) continue;
            if (isPrime(num)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;  // 소수가 아님
            }
        }
        return true;  // 소수
    }
}