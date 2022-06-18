class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            s = s.replaceAll("[0-9]", "");
            
            if (s.length() == 0) return true;
        }
        
        return false;
    }
}