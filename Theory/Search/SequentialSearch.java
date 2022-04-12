import java.util.ArrayList;

public class SequentialSearch {
    public static void main(String[] args) {
        ArrayList<Integer> testArr = new ArrayList<Integer>();
        int result = -1;
        int target = 10;

        for (int i = 0; i < 100; i++) {
            testArr.add((int)(Math.random()*100));
        }

        for (int index = 0; index < testArr.size(); index++) {
            if (testArr.get(index) == target) {
                result = target;
                break;
            }
        }

        System.out.println(result);
    }
}
