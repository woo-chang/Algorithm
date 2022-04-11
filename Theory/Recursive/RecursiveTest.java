import java.util.*;

public class RecursiveTest {
    public static void main(String[] args) {
        System.out.println(count(32));
        System.out.println(count2(32));
    }

    public static int count(int n) {
        if (n == 0) return 1;
        else if (n < 0) return 0;
        return count(n - 1) + count(n - 2) + count(n - 3);
    }

    public static int count2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        return count2(n - 1) + count2(n - 2) + count2(n - 3);
    }
}