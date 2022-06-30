import java.util.ArrayList;

class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[result.size()/2][2];
        for (int i = 0; i < result.size(); i += 2) {
            answer[i/2][0] = result.get(i);
            answer[i/2][1] = result.get(i+1);
        }
        return answer;
    }
    
    public void hanoi(int n, int from, int to, int with) {
        if (n == 1) {
            result.add(from);
            result.add(to);
            return;
        }
        
        hanoi(n-1, from, with, to);
        result.add(from);
        result.add(to);
        hanoi(n-1, with, to, from);
    }
}