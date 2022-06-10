class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] selectTable = new boolean[46];
        int[] rank = new int[]{6, 6, 5, 4, 3, 2, 1};
        int zeroCount = 0;
        int correctCount = 0;
        for(int w : win_nums) {
            selectTable[w] = true;
        }
        for(int l : lottos) {
            if (l == 0)
                ++zeroCount;
            else {
                if(selectTable[l])
                    ++correctCount;
            }
        }
        int[] answer = {rank[correctCount+zeroCount], rank[correctCount]};
        return answer;
    }
}