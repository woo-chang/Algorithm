import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] result = new int[N];
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		while(N-- > 0) {
			if(stack.isEmpty()) {
				stack.push(index);
			} else {
				while(!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
					result[stack.pop()] = arr[index];
				}
				stack.push(index);
			}
			++index;
		}
		while(!stack.isEmpty()) {
			result[stack.pop()] = - 1;
		}
		for(int a : result) {
			sb.append(a + " ");
		}
		sb.replace(sb.length()-1, sb.length(), "\n");
		bw.write(sb.toString());
		bw.flush();
	}
}