import java.util.Arrays;
import java.lang.Math;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        
        answer = new int[arr.length-1];
        
        int index = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex) answer[index++] = arr[i];
        }
        
        return answer;
    }
}