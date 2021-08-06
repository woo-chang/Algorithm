import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		int[] intArr = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < N; i++) {
			map.put(intArr[i], map.get(intArr[i]) == null ? 1 : map.get(intArr[i])+1);
		}
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && map.get(intArr[stack.peek()]) < map.get(intArr[i])) {
				result[stack.pop()] = intArr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		for(int i = 0; i < N; i++) {
			if(i != N-1) {
				sb.append(result[i] + " ");
			} else {
				sb.append(result[i] + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}