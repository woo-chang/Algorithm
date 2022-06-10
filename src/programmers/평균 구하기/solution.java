class Solution {
    public double solution(int[] arrs) {
        double answer = 0;
        for (int arr : arrs) {
            answer += arr;
        }
        return answer/arrs.length;
    }
}