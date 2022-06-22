class Solution {
    public int solution(int num) {
        if (num == 1) return 0;
        int answer = 0;
        long target = num;
        while (answer <= 500) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target * 3 + 1;
            }
            answer += 1;
            
            if (target == 1) return answer;
        }
        return -1;
    }
}