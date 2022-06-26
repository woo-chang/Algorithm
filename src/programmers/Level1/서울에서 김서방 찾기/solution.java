import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        ArrayList<String> lists = new ArrayList<>(Arrays.asList(seoul));
        return "김서방은 " + lists.indexOf("Kim") + "에 있다";
    }
}
// 가독성 측면에서 좋고 배열 길이가 작다보니 for문과 큰 시간 차이가 발생하지 않음