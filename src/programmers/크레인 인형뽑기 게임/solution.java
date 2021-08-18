import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int boardLen = board[0].length;
        for(int m : moves) {
            for(int i = 0; i < boardLen; i++) {
                if(board[i][m-1] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[i][m-1]);      
                    } else {
                        if(stack.peek() == board[i][m-1]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[i][m-1]);
                        }
                    }
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}