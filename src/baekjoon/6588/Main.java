import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static int[] table = new int[1000001];

	public static void removeNum(int now, int end) {
		for(int i = now*2; i <= end; i+=now) {
			table[i] = 0;
		}
	}
	
	public static int nextNum(int now, int end) {
		for(int i = now + 1; i <= end; i++) {
			if(table[i]==1) return i;
		}
		return end;
	}
	
	public static void tableSetting() {
		int now = 2;
		do {
			removeNum(now, 1000000);
			now = nextNum(now, 1000000);
		} while(now * now < 1000001);
	}
	
	public static void checkNum(int num, BufferedWriter bw) throws IOException {
		for(int i = 2; i <= num/2; i++) {
			if(table[i]==0) {
				continue;
			} else {
				if(table[num-i] == 1) {
					bw.write(num + " = " + i + " + " + (num-i) + "\n");
					return;
				}
			}
		}
		bw.write("Goldbach's conjecture is wrong.\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Arrays.fill(table, 1);
		table[0] = 0;
		table[1] = 0;
		tableSetting();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			checkNum(n, bw);
			bw.flush();
		}
	}
}