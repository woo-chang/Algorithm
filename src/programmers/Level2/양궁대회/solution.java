import java.util.Arrays;

class Solution {
    int[] answer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int nowDis = -1;
    public int[] solution(int n, int[] info) {
        int[] lion = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        pro(lion, info, 0, n);
        return nowDis == -1 ? new int[]{-1} : answer;
    }
    
    public boolean isPossible(int[] lion) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > answer[i]) return true;
            else if (lion[i] < answer[i]) return false;
        }
        return true;
    }
    
    public void print(int[] array) {
        for (int i = 0 ; i < 11; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
    
    public void calculateScore(int[] lion, int[] info) {
        int scoreLion = 0;
        int scoreInfo = 0;
        for (int i = 0; i < 11; i++) {
            if (lion[i] == 0 && info[i] == 0) continue;
            
            if (lion[i] > info[i]) {
                scoreLion += (10-i);
            } else {
                scoreInfo += (10-i);
            }
        }
        
        int dis = scoreLion - scoreInfo;
        
        if (dis > 0 && (dis >= nowDis)) {
            if (dis == nowDis && !isPossible(lion)) return;
            
            answer = Arrays.copyOf(lion, 11);
            nowDis = dis;
        }
    }
    
    public void pro(int[] lion, int[] info, int index, int count) {
        if (index == 11 || count == 0) {
            lion[10] = count;
            calculateScore(lion, info);
            lion[10] = 0;
            return;
        }
        
        // 점수 획득
        if (count > info[index]) {
            lion[index] = info[index] + 1;
            pro(lion, info, index+1, count-info[index]-1);
            lion[index] = 0;
        }
        
        // 점수 획득 X
        pro(lion, info, index+1, count);
    }
}