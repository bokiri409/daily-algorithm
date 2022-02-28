package BOJ;

import java.util.Scanner;

/*
 * 2022.02.28 daily algo/commit
 * 
 * DP - 자료형, 연산 시 overflow에 주의한다!
 */

public class boj_11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		long[] dp = new long[1000];
		dp[0] = 1;
		dp[1] = 2;
		for(int i=2; i<n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007;
		}
		
		System.out.println(dp[n-1]);
	}

}
