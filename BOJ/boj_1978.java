package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.28 daily algo/commit
 */

public class boj_1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int num = 0;
		int cnt = 0; // 소수 개수
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num > 1) {
				if(cal(num)) {
					cnt += 1;
				}
			}
		}
		System.out.print(cnt);
		br.close();
	}
	
	static boolean cal(int num) {
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
