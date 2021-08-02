package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.08.01 daily algo/commit
 */

public class boj_11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=2; i<=N; i++) {
			if(N % i == 0) {
				System.out.println(i);
				N /= i;
				i = 1; // 다시 처음으로 돌아간다.
			}
		}
		
		
		br.close();
	}

}
