class Solution {
    public int solution(int n) {
        int[] fibos = new int[n+1];
        fibos[0] = 0;
        fibos[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibos[i] = (fibos[i-1] + fibos[i-2]) % 1234567;
        }
        return fibos[n];
    }
    
}