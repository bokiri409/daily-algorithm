package BOJ;

import java.util.Scanner;

/*
 * 2022.06.23 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * 추가된 조건을 점화식에 넣을 수 있는지 체크하고 점화식으로 표현해본다. 
 * 
 * dp[i][j] : 길이가 i이고, 마지막 수가 j로 끝나는 것의 개수. j는 0 or 1
 * dp[i][j] = dp[i-1][0] + dp[i-1][1]
 */

public class boj_2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] dp = new long[N+1][2];
		dp[1][0] = 0; // 0으로 시작x
		dp[1][1] = 1;
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		sc.close();
		System.out.println(dp[N][0] + dp[N][1]);
	}
}
