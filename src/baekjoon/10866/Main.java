import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] deque = new int[20000];
	static int start = 10000;
	static int end = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String instruction = st.nextToken();
			if(instruction.equals("push_front")) {
				int X = Integer.parseInt(st.nextToken());
				deque[--start] = X;
			} else if(instruction.equals("push_back")) {
				int X = Integer.parseInt(st.nextToken());
				deque[end++] = X;
			} else if(instruction.equals("pop_front")) {
				if(start < end) {
					bw.write(deque[start] + "\n");
					deque[start++] = 0;
				} else {
					bw.write(-1 + "\n");
				}
			} else if(instruction.equals("pop_back")) {
				if(start < end) {
					bw.write(deque[end-1] + "\n");
					deque[--end] = 0;
				} else {
					bw.write(-1 + "\n");
				}
			} else if(instruction.equals("size")) {
				bw.write(end-start + "\n");
			} else if(instruction.equals("empty")) {
				if(start == end) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			} else if(instruction.equals("front")) {
				if(start < end) {
					bw.write(deque[start] + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			} else if(instruction.equals("back")) {
				if(start < end) {
					bw.write(deque[end-1] + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			}
			bw.flush();
		}
	}
}