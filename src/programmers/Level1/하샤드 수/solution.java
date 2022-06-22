class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return x % h == 0;
    }
}