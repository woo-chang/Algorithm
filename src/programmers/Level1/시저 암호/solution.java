class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                answer += (char)((c + n - 'a') % 26 + 'a');
            } else if (Character.isUpperCase(c)) {
                answer += (char)((c + n - 'A') % 26 + 'A');
            } else {
                answer += c;
            }
        }
        return answer;
    }
}