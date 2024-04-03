import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String s;
        int cnt = 0;

        while (true) {
            String treeName = br.readLine();

            if (treeName == null || treeName.isBlank()) {
                break;
            }
            cnt++;

            if (map.containsKey(treeName)) {
                map.put(treeName,map.get(treeName)+1);
            } else {
                list.add(treeName);
                map.put(treeName, 1);
            }
        }

        Collections.sort(list);
        for (String name : list) {
            Integer treeCnt = map.get(name);
            System.out.println(name + " " + String.format("%.4f", ((double)treeCnt/(double)cnt)*100));
        }
    }
}