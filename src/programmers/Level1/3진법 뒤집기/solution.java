import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n % 3);
            n = n / 3;
        }
        String reversedStr = sb.reverse().toString();
        return Integer.parseInt(reversedStr, 3);
    }
}