import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String s : completion) {
            map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);
        }
        for(String s : participant) {
            if(map.get(s) == null) {
                answer = s;
                break;
            } else {
                int count = map.get(s);
                if(count == 0) {
                    answer = s;
                    break;
                } else {
                    map.put(s, count-1);
                }
            }
        }
        return answer;
    }
}