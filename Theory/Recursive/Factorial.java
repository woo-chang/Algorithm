import java.util.ArrayList;
import java.util.List;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));

        ArrayList<Integer> testArray = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            testArray.add(i);
        }

        System.out.println(sum(testArray));
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int sum(List<Integer> dataList) {
        if (dataList.size() == 0) return 0;
        return dataList.get(dataList.size() - 1) + sum(dataList.subList(0, dataList.size() - 1));
    }
}
