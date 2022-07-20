class Solution {
    public int solution(int n) {
        int answer = 0;
        int target = n - 1;
        for(int i = 2; i <= target; i++) {
            if(target%i == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}