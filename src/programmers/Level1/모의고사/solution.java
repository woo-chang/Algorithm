import java.util.*;

class Solution {
    
    int[] one = {1, 2, 3, 4, 5};
    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int maxResult = -1;
        int[] result = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(one[i%one.length] == answers[i]) ++result[0];
            if(two[i%two.length] == answers[i]) ++result[1];
            if(three[i%three.length] == answers[i]) ++result[2];
        }
        for(int i = 0; i < 3; i++)
            if(maxResult < result[i]) maxResult = result[i];
        for(int i = 0; i < 3; i++)
            if(result[i] == maxResult) answer.add(i+1);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}