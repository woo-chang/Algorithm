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
		String S = br.readLine();
		int sLength = S.length();
		int index = 0;
		while(index < sLength) {
			if(S.charAt(index) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				char tag = '<';
				while(tag != '>') {
					sb.append(tag);
					tag = S.charAt(++index);
				}
				sb.append(tag);
				++index;
			} else {
				if(S.charAt(index) == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				} else {
					stack.push(S.charAt(index));
				}
				++index;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		bw.write(sb.toString() + "\n");
		bw.flush();
	}
}