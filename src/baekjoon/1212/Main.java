import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static String[] result = {"000", "001", "010", "011", "100", "101", "110", "111"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String arr = br.readLine();
		boolean start = true;
		if(arr.length() == 1) {
			bw.write(arr);
		} else {
			for(int i = 0; i < arr.length(); i++) {
				if(start) {
					if(arr.charAt(i) == '1') {
						bw.write("1");
					} else if(arr.charAt(i) == '2') {
						bw.write("10");
					} else if(arr.charAt(i) == '3') {
						bw.write("11");
					} else {
						bw.write(result[Integer.parseInt(Character.toString(arr.charAt(i)))]);
					}
					start = false;
				} else {
					bw.write(result[Integer.parseInt(Character.toString(arr.charAt(i)))]);
				}
				bw.flush();
			}
		}
		bw.write("\n");
		bw.flush();
	}
}