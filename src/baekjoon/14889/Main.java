
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 파라미터로 받은 배열의 순서를 다음 순열로 바꿔주는 함수
	public static boolean next_permutation(int[] arr) {
		int i = arr.length-1;
		// 내림차순의 시작점 구하기
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		// 끝까지 도달했다면 더 이상 다음 순열은 존재하지 않음을 의미
		if (i <= 0) return false;
		int j = arr.length-1;
		// i-1번째 수보다 큰 수는 끝에서부터 찾게 되면 무조건 존재
		while(arr[i-1] >= arr[j]) j--;
		// i-1번째 수보다 큰 수와 swap
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		j = arr.length-1;
		// 차례대로 하나씩 스왑해주는 작업
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N+1][N+1];
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] sequence = new int[N];
		// 2팀으로 나눠야 하므로 0, 1 개수를 반반으로 지정
		for(int i = 0; i < N/2; i++) {
			sequence[i] = 1;
		}
		// 우선 정렬시킨 후 순열로 하나씩 구하는 작업
		Arrays.sort(sequence);
		
		int result = 987654321;
		do {
			int zero = 0;
			int one = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					
					if(sequence[i] == 0) {
						if(sequence[j] == 0) {
							zero += table[i+1][j+1];
						}
					}
					else {
						if(sequence[j] == 1) {
							one += table[i+1][j+1];
						}
					}
				}
			}
			// 각 순서에 의해 구한 값이 이전의 최소값보다 작으면 최소값 교체
			int absNum = Math.abs(zero-one);
			if(absNum < result) result = absNum;
		} while(next_permutation(sequence));
		
		System.out.println(result);
	}
}
