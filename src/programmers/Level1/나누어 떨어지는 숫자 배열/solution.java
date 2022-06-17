import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) index.add(arr[i]);
        }
        
        if (index.size() == 0) return new int[]{-1};
        
        Collections.sort(index);
        
        int[] answer = new int[index.size()];
        for (int i = 0; i < index.size(); i++) {
            answer[i] = index.get(i);
        }
        return answer;
    }
}
// 최대 1.33ms