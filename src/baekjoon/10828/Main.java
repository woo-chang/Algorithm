import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] stack = new int[10001];
	static int count = 0;
	
	public static void push(int num) {
		stack[++count] = num;
	}
	
	public static int pop() {
		if(count > 0) {
			int returnNum = stack[count];
			stack[count--] = 0;
			return returnNum;
		} else {
			return -1;
		}
	}
	
	public static int size() {
		return count;
	}
	
	public static int empty() {
		if(count == 0) return 1;
		else return 0;
		
	}
	
	public static int top() {
		if(count > 0) {
			return stack[count];
		} else {
			return -1;
		}
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push":
					int pushNum = Integer.parseInt(st.nextToken());
					push(pushNum);
					break;
				case "pop":
					bw.write(pop()+"\n");
					bw.flush();
					break;
				case "size":
					bw.write(size()+"\n");
					bw.flush();
					break;
				case "empty":
					bw.write(empty()+"\n");
					bw.flush();
					break;
				case "top":
					bw.write(top()+"\n");
					bw.flush();
					break;
			}
		}
	}
}