class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for(int i = 1; i <= count; i++) {
            sum += price * i;
        }

        System.out.println(sum);
        return sum >= money ? sum - money : 0;
    }
}