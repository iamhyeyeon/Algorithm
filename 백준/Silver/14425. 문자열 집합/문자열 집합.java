import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer command;

        command = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(command.nextToken());
        int M = Integer.parseInt(command.nextToken());

        Set<String> set = new HashSet<>();
        int cnt = 0;

        for (int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        for (int i=0; i<M; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}