import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] result = new int[N];
		int max = 1;
		Arrays.fill(result, 1);
		for(int i = 1; i < N; i++) {
			for(int j = i-1; j >=0; j--) {
				if(sequence[i] > sequence[j]) {
					result[i] = Math.max(result[i], result[j]+1);
				}
			}
			max = Math.max(max, result[i]);
		}
		System.out.println(max);
	}
	
}