class Solution {
    boolean solution(String s) {
        String lowerCase = s.toLowerCase();
        int countP = lowerCase.length() - lowerCase.replaceAll("p", "").length();
        int countY = lowerCase.length() - lowerCase.replaceAll("y", "").length();
        return countP == countY;
    }
}