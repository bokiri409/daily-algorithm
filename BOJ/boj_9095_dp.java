package BOJ;

import java.util.Scanner;

/*
 * 2022.06.21 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * dp[n] = dp[n-1] + dp[n-2] + dp[n-3] 
 * dp[0] = 1로 정해놓고 풀어도 된다. (숫자를 0개쓰는 방법 1가지)
 */

public class boj_9095_dp {
	
	static final int N = 12;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[] dp = new int[N];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			
			for(int j=4; j<=n; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			System.out.println(dp[n]);
		}
		sc.close();
	}

}
