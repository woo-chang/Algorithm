import java.util.*;

class Solution {
    Set<String> dic = new HashSet<>();
    String[] elements = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        dfs(0, "");
        ArrayList<String> lists = new ArrayList<>(dic);
        Collections.sort(lists);
        return lists.indexOf(word)+1;
    }
    
    public void dfs(int pos, String result) {
        if (result.length() > 0) {
            dic.add(result);
        }
        
        if (pos >= elements.length) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(pos + 1, result + elements[i]);
            dfs(pos + 1, result);
        }  
    }
}