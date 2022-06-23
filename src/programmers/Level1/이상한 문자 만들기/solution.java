class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split("");
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (array[i].equals(" ")) {
                answer += array[i];
                index = 0;
                continue;
            }
            
            if (index % 2 == 0) {
                answer += array[i].toUpperCase();
            } else {
                answer += array[i].toLowerCase();
            }
            index += 1;
        }
        return answer;
    }
}