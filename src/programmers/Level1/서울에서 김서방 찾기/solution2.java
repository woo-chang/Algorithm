import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {
    public String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        return "김서방은 " + index + "에 있다";
    }
}
// 중간에 break가 걸리기 때문에 약간 빠름