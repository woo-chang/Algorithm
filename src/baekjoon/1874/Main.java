import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int	index = 1;
		while(N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if(index <= num) {
				while(index <= num) {
					stack.push(index);
					++index;
					sb.append("+\n");
				}
				sb.append("-\n");
				stack.pop();
			} else {
				if(stack.peek() == num) {
					sb.append("-\n");
					stack.pop();
				} else {
					sb.setLength(0);
					sb.append("NO\n");
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}