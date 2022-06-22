class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = max(n, m);
        answer[1] = min(n, m, answer[0]);
        return answer;
    }
    
    public int max(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
    
    public int min(int n, int m, int max) {
        return (n / max) * (m / max) * max;
    }
}