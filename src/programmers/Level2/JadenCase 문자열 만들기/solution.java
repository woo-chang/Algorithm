import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[\\w]{1,}[\\s]{0,}");
        Matcher matcher = pattern.matcher(s.toLowerCase());
        while(matcher.find()) {
            String target = matcher.group();
            if (Character.isDigit(target.charAt(0))) {
                sb.append(target);
            } else {
                sb.append(Character.toUpperCase(target.charAt(0)));
                sb.append(target.substring(1));
            }
        }
        return sb.toString();
    }
}