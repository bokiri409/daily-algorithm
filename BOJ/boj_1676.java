package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.08.03 daily algo/commit
 * 
 * 직접 팩토리얼을 구하기에는 500!이 너무 크다.
 * 끝 숫자 0만 구할 수 있는 방법으로 구하기 => 2*5 한쌍에 0 1개
 */

public class boj_1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = N/5;
		N /= 5;
		while(N >= 5) {
			if(N == 0) {
				break;
			}
			N /= 5;
			cnt += N;
		}
		System.out.println(cnt);
		br.close();
	}

}
