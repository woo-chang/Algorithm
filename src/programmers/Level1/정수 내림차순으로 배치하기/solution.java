import java.util.*;

class Solution {
    public long solution(long n) {
        String[] array = String.valueOf(n).split("");
        
        Arrays.sort(array, Collections.reverseOrder());
        
        String str = "";
        
        for (int i = 0; i < array.length; i++) {
            str += array[i];
        }
        
        return Long.parseLong(str);
    }
}