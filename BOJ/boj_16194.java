package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.06.21 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * dp[n] = Math.max(dp[n-1] + costs[1], dp[n-2] + costs[2], ... , dp[0] + costs[n])
 */

public class boj_16194 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] costs = new int[N+1];
		for(int i=1; i<=N; i++) {
			costs[i] = sc.nextInt(); 
		}
		sc.close();
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.min(dp[i], costs[j] + dp[i-j]);
			}
		}
		System.out.println(dp[N]);
	}

}
