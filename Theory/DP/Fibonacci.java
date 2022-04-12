public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(9));
        System.out.println(fibonacciDP(9));
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciDP(int n) {
        int[] memory = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            if (i <= 1) {
                memory[i] = i;
            } else {
                memory[i] = memory[i-1] + memory[i-2];
            }
        }

        return memory[n];
    }
}