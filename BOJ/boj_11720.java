package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.08.18 daily algo/commit
 */

public class boj_11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += (s.charAt(i) - '0');
		}
		
		System.out.print(sum);
		br.close();
	}

}
