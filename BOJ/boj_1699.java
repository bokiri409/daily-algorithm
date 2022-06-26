package BOJ;

import java.util.Scanner;

/*
 * 2022.06.26 daily algorithm
 * 
 * DP
 * dp[n] : 제곱수들의 항들의 개수
 * dp[n] = dp[n-i^2] + i^2
 */

public class boj_1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			dp[i] = i; // 1^2로만 이루어졌을 때 개수 
			for(int j=1; j*j<=i; j++) {
				if(dp[i] > dp[i-j*j] + 1) {
					dp[i] = dp[i-j*j] + 1;
				}
			}
		}
		sc.close();
		System.out.println(dp[N]);
	}

}
