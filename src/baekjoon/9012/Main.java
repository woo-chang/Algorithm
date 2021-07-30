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
		Stack<String> stack = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String str = br.readLine();
			boolean flag = true;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.push("(");
				} else {
					if(!stack.empty()) stack.pop();
					else {
						flag = false;
						break;
					}
				}
			}
			if(flag && stack.isEmpty()) bw.write("YES\n");
			else bw.write("NO\n");
			bw.flush();
			stack.clear();
		}
		
	}
}