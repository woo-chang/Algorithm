import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            int weight = people[right];
            right -= 1;
            answer += 1;
            if (right - left < 0) break;
            
            if (limit - weight >= people[left]) {
                left += 1;
            }
            
        }
        
        return answer;
    }
}