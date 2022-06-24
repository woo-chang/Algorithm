class Solution {
    int[][] map;
    
    public int solution(int n) {
        map = new int[n][n];
        return dfs(n, 0);
    }
    
    public boolean isPossible(int x, int y, int n) {
        for (int i = 0; i < y; i++) {
            if (map[i][x] == 1) return false;
        }
        
        for (int i = 1; i <= y; i++) {
            if (y-i >= 0 && x-i >= 0) {
                if (map[y-i][x-i] == 1) return false;
            }
            if (y-i >= 0 && x+i < n) {
                if (map[y-i][x+i] == 1) return false;
            }
        }
        
        return true;
    }
    
    public int dfs(int n, int count) {
        if (count == n) {
            return 1;
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (isPossible(i, count, n)) {
                map[count][i] = 1;
                answer += dfs(n, count + 1);
                map[count][i] = 0;
            }
        }
        
        return answer;
    }
    
    class Point {
        public int x;
        public int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}