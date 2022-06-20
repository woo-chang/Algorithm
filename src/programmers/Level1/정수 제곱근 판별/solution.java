class Solution {
    public long solution(long n) {
        double d = Math.sqrt(n);
        if (d == (long)d) {
            return (long)Math.pow(d+1, 2);
        }
        return -1;
    }
}