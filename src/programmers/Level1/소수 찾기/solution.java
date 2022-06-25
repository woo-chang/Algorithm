class Solution {
    int[] checked = new int[1000001];
    
    public int solution(int n) {
        int answer = 0;
        checked[0] = 1;
        checked[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            checkPrimeNumber(i, n);
        }
        for (int i = 0; i <= n; i++) {
            if (checked[i] == 0) answer += 1;
        }
        return answer;
    }
    
    public void checkPrimeNumber(int start, int end) {
        for (int i = 2;  start * i <= end; i++) {
            checked[start*i] = 1;
        }
    }
}