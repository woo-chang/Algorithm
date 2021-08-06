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
		Stack<Character> stack = new Stack<>();
		char[] charArr = br.readLine().toCharArray();
		char preChar = ' ';
		int result = 0;
		for(char c : charArr) {
			if(c == '(') {
				stack.push(c);
			} else {
				if(preChar == '(') {
					stack.pop();
					result += stack.size();
				} else {
					stack.pop();
					result += 1;
				}
			}
			preChar = c;
		}
		bw.write(result + "\n");
		bw.flush();
	}
}