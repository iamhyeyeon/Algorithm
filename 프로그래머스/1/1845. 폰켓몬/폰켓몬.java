import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> phoneketmonSet = new HashSet<>();
        int num = nums.length/2;
        for (int i = 0; i<nums.length; i++) {
            phoneketmonSet.add(nums[i]);
        }
        
        //num, 중복제거한 set 크기 비교
        if (num >= phoneketmonSet.size()) {
            answer = phoneketmonSet.size();
        } else {
            answer = num;
        }
        
        return answer;
    }
}