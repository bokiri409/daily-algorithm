package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mul = 1;
		
		for(int i=1; i<=N; i++) {
			mul *= i;
		}
		if(N == 0) {
			System.out.println(1);
		}
		else {
			System.out.println(mul);
		}
		
		br.close();
	}

}
