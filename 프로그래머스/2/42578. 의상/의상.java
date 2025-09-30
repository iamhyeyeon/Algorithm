import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clotheMap = new HashMap<>();
        
        // 종류, 이름 hashMap 만들기 --> 이름은 알 필요가없지
        Arrays.stream(clothes)
            .forEach(clothe -> clotheMap
            .merge(clothe[1], 1, Integer::sum));
                     
        for (Integer type : clotheMap.values()) {
            answer *= type+1;
        }
        
        return answer-1;
    }
}