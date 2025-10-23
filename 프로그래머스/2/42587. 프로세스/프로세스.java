import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        //우선순위 큐 생성
        PriorityQueue<Integer> queue = Arrays.stream(priorities)
            .boxed()
            .collect(Collectors.toCollection(
                () -> new PriorityQueue<>(Collections.reverseOrder())
            ));
        
        while (!queue.isEmpty()) {
            int order = queue.peek();
            for (int i=0; i<priorities.length; i++) {
                int process = priorities[i];
                if (process == order) {
                    answer++;
                    if (location == i) {
                        return answer;
                    }
                    queue.poll();
                    priorities[i] = 0;
                    order = queue.peek();
                }
            }
        }
        
        return answer;
    }
}