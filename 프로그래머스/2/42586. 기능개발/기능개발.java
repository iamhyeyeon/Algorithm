import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        //작업일 계산하기
        for (int i=0; i<progresses.length; i++) {
            int days = (int) Math.ceil((double)(100-progresses[i])/speeds[i]);
            queue.offer(days);
        }
        
        while(!queue.isEmpty()) {
            int cnt = 1;
            int first = queue.poll();
           while (queue.peek() != null && queue.peek() <= first) {
                queue.poll();
                cnt++;
           }             
            
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}