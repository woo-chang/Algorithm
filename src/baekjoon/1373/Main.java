import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static String[] result = {"000", "001", "010", "011", "100", "101", "110", "111"};
	static String[] result1 = {"00", "01", "10", "11"};
	
	public static String toEight(int start, int end, String arr) {
		if(start < 0) start = 0;
		String target = arr.substring(start, end+1);
		if(target.length() == 3) {
			for(int i = 0; i < 8; i++) {
				if(target.equals(result[i]))
					return Integer.toString(i);
			}
		} else if (target.length() == 2) {
			for(int i = 0; i < 4; i++) {
				if(target.equals(result1[i]))
					return Integer.toString(i);
			}
		} else {
			if(target.equals("0"))
				return Integer.toString(0);
			return Integer.toString(1);
		}
		
		return "Fail";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<String> answer = new ArrayList<>();
		String arr = br.readLine();
		int start = arr.length()-3;
		int end = arr.length()-1;
		while(end >= 0) {
			answer.add(toEight(start, end, arr));
			start -= 3;
			end -= 3;
		}
		Collections.reverse(answer);
		for(int i = 0; i < answer.size(); i++) {
			bw.write(answer.get(i));
			bw.flush();
		}
		bw.write("\n");
		bw.flush();
	}
}
