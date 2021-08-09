import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void removeTable(int[] table, int num, int limit) {
		int index = 2;
		while(num * index <= limit) {
			table[num * index] = 1;
			++index;
		}
	}
	
	public static int findNextNum(int[] table, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(table[i]==0) return i;
		}
		return end;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] table = new int[input[1]+1];
		table[0] = 1;
		table[1] = 1;
		// 0일때 가능한 것으로 인식
		// 1이면 소수가 아님
		int start = 2; // 맨 처음으로 시작하는 소수
		do {
			removeTable(table, start, input[1]);
			start = findNextNum(table, start+1, input[1]);
		} while(start * start <= input[1]);
		
		for(int i = input[0]; i <= input[1]; i++) {
			if(table[i] == 0) {
				sb.append(i + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
}
