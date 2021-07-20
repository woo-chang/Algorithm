import java.util.Arrays;

class Solution {

    public int distance(int depart, int destination) {
        if(depart == 0) depart = 11;
        if(destination == 0) destination = 11;

        int x = Math.abs(((depart-1) % 3) - ((destination-1) % 3));
        int y = Math.abs(((depart-1) / 3) - ((destination-1) / 3));
        return x + y;
    }

    public boolean inList(int[] target, int num) {
        return Arrays.stream(target).anyMatch(n -> n == num);
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftNum = {1, 4, 7};
        int[] rightNum = {3, 6, 9};
        int leftPos = 10;
        int rightPos = 12;
        for(int i = 0; i < numbers.length; i++) {
            if(inList(leftNum, numbers[i])) {
                answer += "L";
                leftPos = numbers[i];
            }
            else if(inList(rightNum, numbers[i])) {
                answer += "R";
                rightPos = numbers[i];
            }
            else {
                int leftDis = distance(leftPos, numbers[i]);
                int rightDis = distance(rightPos, numbers[i]);
                if(leftDis > rightDis) {
                    answer += "R";
                    rightPos = numbers[i];
                }
                else if(rightDis > leftDis) {
                    answer += "L";
                    leftPos = numbers[i];
                }
                else {
                    if(hand.equals("left")) {
                        answer += "L";
                        leftPos = numbers[i];
                    }
                    else {
                        answer += "R";
                        rightPos = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}