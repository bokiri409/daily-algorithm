package BOJ;

import java.util.Scanner;

/*
 * 2022.06.22 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * 추가된 조건을 점화식에 넣을 수 있는지 체크하고 점화식으로 표현해본다. 
 * 
 * dp[i][j] = 길이 i, 마지막 숫자 j인 계단 수의 개수 
 * 가능한 수는 -1 또는 +1 밖에 없기 때문에 이전 수의 마지막 수의 -1, +1 개수를 더해주면 된다.
 * dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
 * 
 * 단, 0과 9일 때는 범위를 벗어나는 경우를 따로 처리해줘야 한다.
 */

public class boj_10844 {
	
	static long[][] dp;
	static final int num = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new long[n+1][num];
		for(int i=1; i<num; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<num; j++) {
				// i-1 이 안됨 
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				}
				// i+1 이 안됨 
				else if(j == 9) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				}
				dp[i][j] %= 1000000000;
			}
		}
		sc.close();
		
		long ans = 0;
		for(int i=0; i<num; i++) {
			ans += dp[n][i];
		}
		System.out.println(ans % 1000000000);
	}

}
