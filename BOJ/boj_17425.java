package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.05.05 daily algo/commit
 * Math
 * 효율성과 시간복잡도를 잘 따져보자.
 * 테스트케이스마다 다시 다 구하면 시간이 오래걸리므로 
 * 1000000개의 모든 약수의 합을 미리 구해놓고 맞는 답을 꺼내온다.
 */

public class boj_17425 {
	static final int max = 1000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 각 수의 약수의 합을 미리 배열로 구해놓는다.
		long[] list = new long[max+1];
		for(int i=1; i<=max; i++) {
			for(int j=1; i*j<=max; j++) {
				list[i*j] += i;
			}
		}
		
		// 미리 누적합을 구해놔야 뒤에서 합을 계속 구할 필요가 없게 된다.
		for(int i=2; i<=max; i++) {
			list[i] += list[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
//			int sum = 0;
//			for(int i=1; i<=n; i++) {
//				sum += list[i];
//			}
			sb.append(list[n] + "\n");
		}
		System.out.println(sb);
		
	}

}
