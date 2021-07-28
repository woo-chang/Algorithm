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
		Stack<Character> stack = new Stack<>();
		int C = Integer.parseInt(br.readLine());
		while(C-- > 0) {
			String input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == ' ') {
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				} else {
					stack.push(input.charAt(i));
				}
			}
			while(!stack.empty()) {
				sb.append(stack.pop());
			}
			bw.write(sb.toString()+"\n");
			bw.flush();
			sb.setLength(0);
		}
	}
}