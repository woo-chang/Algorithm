class Solution {
    int[] scores = new int[3];
    char[] bonus = new char[3];
    char[] options = new char[3];
    
    public int solution(String dartResult) {
        input(dartResult);
        
        //print();
        
        return calculate();
    }
    
    public void print() {
        for (int i = 0; i < 3; i++) {
            System.out.println(scores[i]);
            System.out.println(bonus[i]);
            System.out.println(options[i]);
        }
    }
    
    public int calculate() {
        int answer = 0;
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            int score = scores[i];
            if (bonus[i] == 'S') {
                score = (int)Math.pow(score, 1);
            } else if (bonus[i] == 'D') {
                score = (int)Math.pow(score, 2);
            } else {
                score = (int)Math.pow(score, 3);
            }
            
            result[i] = score;
            
            if (options[i] == '*') {
                if (i > 0) {
                    result[i-1] = result[i-1]*2;
                    result[i] = result[i]*2;
                } else {
                    result[i] = result[i]*2;
                }
            } else if (options[i] == '#') {
                result[i] = -result[i];
            }
        }
        
        for (int i = 0; i < 3; i++) {
            answer += result[i];
        }
        
        return answer;
    }
    
    public void input(String dartResult) {
        int index = 0;
        int count = 0;
        String score = "";
        while (index < dartResult.length()) {
            char now = dartResult.charAt(index);
            if (now == 'S' || now == 'D' || now == 'T') {
                if (index + 1 < dartResult.length() && !Character.isDigit(dartResult.charAt(index+1))) {
                    scores[count] = Integer.parseInt(score);
                    bonus[count] = now;
                    options[count] = dartResult.charAt(index+1);
                    index += 2;
                } else {
                    scores[count] = Integer.parseInt(score);
                    bonus[count] = now;
                    options[count] = 'N';
                    index += 1;
                }
                score = "";
                count += 1;
            } else {
                score += String.valueOf(now);
                index += 1;
            }
        }
    }
}