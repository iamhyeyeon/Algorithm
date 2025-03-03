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

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            list.add(input);
            map.put(input, i+1);

        }

        //숫자면
        for (int i=0; i<M; i++) {
            String input = br.readLine();
            if (input.matches("\\d+")) {
                String name = list.get(Integer.parseInt(input) - 1);
                System.out.println(name);
            } else {
                System.out.println(map.get(input));
            }
        }
    }
}