import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Stack<String> leftStack = new Stack<>();
		Stack<String> rightStack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			leftStack.push(Character.toString(str.charAt(i)));
		}
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			String instruction = st.nextToken();
			if(instruction.equals("L")) {
				if(!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
			} else if (instruction.equals("D")) {
				if(!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
			} else if (instruction.equals("B")) {
				if(!leftStack.isEmpty()) {
					leftStack.pop();
				}
			} else {
				leftStack.push(st.nextToken());
			}
		}
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		bw.write(sb.toString() + "\n");
		bw.flush();
	}
}