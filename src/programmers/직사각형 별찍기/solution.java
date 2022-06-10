import java.util.*;
import java.io.*;

class Solution {
    
    static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
    }
    
    static FastReader fr = new FastReader();
    static int N, M;
    
    public static void main(String[] args) {
        input();
        
        for (int height = 1; height <= M; height++) {
            for (int width = 1; width <= N; width++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}