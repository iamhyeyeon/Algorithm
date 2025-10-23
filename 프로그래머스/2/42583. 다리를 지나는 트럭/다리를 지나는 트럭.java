import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        
        //얼리 처리
        for (int i=0; i<truck_weights.length; i++) {
            sum += truck_weights[i];
        }
        if (sum <= weight) {
            return bridge_length + truck_weights.length;
        }
        
        Queue<Integer> bridgeQueue = new LinkedList<>();
        Queue<Integer> queue = Arrays.stream(truck_weights)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        
        sum = 0;
        while (!queue.isEmpty() || !bridgeQueue.isEmpty()) {
            if (bridgeQueue.size() == bridge_length) {
                sum-=bridgeQueue.poll();
            } else if (queue.isEmpty()) {
                bridgeQueue.poll();
            }
            
            if (!queue.isEmpty() && sum+queue.peek() <= weight) {
                Integer truck = queue.poll();
                sum += truck;
                bridgeQueue.add(truck);
            } else if (!queue.isEmpty()) {
                bridgeQueue.add(0);
            }
            answer++; 
        }
        
        return answer;
    }
}