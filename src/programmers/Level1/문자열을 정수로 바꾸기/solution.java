import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String sign = "";
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            if (isNum(s.charAt(i) + "")) {
                num += s.charAt(i);
            } else {
                if (sign != "") {
                    answer += Integer.parseInt(sign+num);
                    sign = "";
                } else {
                    sign = s.charAt(i) + "";
                }
            }
        }
        answer += Integer.parseInt(sign+num);
        return answer;
    }

    public boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}