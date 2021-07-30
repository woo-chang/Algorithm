import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] queue = new int[10001];
	static int start = 0;
	static int end = 0;
	static int count = 0;
	
	public static void push(int x) {
		queue[end++] = x;
		++count;
	}
	
	public static int pop() {
		if(count == 0) {
			return -1;
		} else {
			int returnNum = queue[start];
			count -= 1;
			queue[start++] = 0;
			return returnNum;
		}
	}
	
	public static int count() {
		return count;
	}
	
	public static int empty() {
		return count == 0 ? 1 : 0;
	}
	
	public static int front() {
		return count == 0 ? -1 : queue[start];
	}
	
	public static int back() {
		return count == 0 ? -1 : queue[end-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String instruction = st.nextToken();
			switch(instruction) {
				case "push":
					int X = Integer.parseInt(st.nextToken());
					push(X);
					break;
				case "pop":
					bw.write(pop()+"\n");
					break;
				case "size":
					bw.write(count()+"\n");
					break;
				case "empty":
					bw.write(empty()+"\n");
					break;
				case "front":
					bw.write(front()+"\n");
					break;
				case "back":
					bw.write(back()+"\n");
					break;
				default:
					bw.write("Error\n");
					break;
			}
			bw.flush();
		}
	}
}