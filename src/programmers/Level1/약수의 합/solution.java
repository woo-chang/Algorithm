import java.lang.Math;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += i;
                if (i != (n/i)) answer = answer + (n/i);
            }
        }
        return answer;
    }
}