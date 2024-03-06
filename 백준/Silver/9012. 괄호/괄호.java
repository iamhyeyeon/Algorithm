import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            String input = sc.next();
            result.add(vpsJudgment(input));
        }
        for (String res : result) {
            System.out.println(res);
        }
    }

    public static String vpsJudgment(String input) {
        List<String[]> list = new ArrayList<>();
        int length = input.length();

        if ('(' == input.charAt(length-1)) return "NO";

        for (int j=0; j<length; j++) {
            char at = input.charAt(j);
            if (at == '(') {
                String[] bracket = {"("};
                list.add(bracket);
            } else if (!list.isEmpty()){
                String[] strings = list.get(list.size() - 1);
                if (strings[0].equals("(")) list.remove(list.size()-1);
            } else if (at == ')') {
                String[] bracket = {")"};
                list.add(bracket);
            }
        }

        return (list.isEmpty()) ? "YES" : "NO";
    }
}