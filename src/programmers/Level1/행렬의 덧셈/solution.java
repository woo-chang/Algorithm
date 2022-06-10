class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr1[0].length;
        int[][] answer = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}