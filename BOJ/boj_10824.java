package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.09 daily algo/commit
 * 
 * 숫자 범위 잘 생각하기
 */

public class boj_10824 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long answer = 0;
		for(int i=0; i<2; i++) {
			String A = st.nextToken();
			String B = st.nextToken();
			
			long N = Long.parseLong(A+B);
			answer += N;
		}
		System.out.print(answer);
		br.close();
	}

}
