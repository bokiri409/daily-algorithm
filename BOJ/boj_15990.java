package BOJ;

import java.util.Scanner;

/*
 * 2022.06.21 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * 추가된 조건을 점화식에 넣을 수 있는지 체크하고 점화식으로 표현해본다. 
 * 연속된 수를 사용하면 안되기 때문에 마지막으로 끝난 수를 표기한다.
 * dp[i][j] = j로 끝나는 수 
 * ----------------------
 * dp[n][1] = dp[n-1][2] + dp[n-1][3]
 * dp[n][2] = dp[n-1][1] + dp[n-1][3]
 * dp[n][3] = dp[n-1][1] + dp[n-1][2]
 * answer = dp[n][1] + dp[n][2] + dp[n][3]
 * 
 * 입력받을 때마다 dp를 계산해주면 시간초과가 난다. 
 * 따라서 입력받은 가장 큰 값으로 dp를 먼저 꾸려주고, 나머지는 dp에서 값을 꺼내오면 된다!
 */

public class boj_15990 {
	
	static final int size = 100000;
	static long[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		dp = new long[size+1][4];
		dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0; // 초기값은 1로 초기화해준다.
		dp[2][1] = 0; dp[2][2] = 1; dp[2][3] = 0;
		dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
		
		int t = sc.nextInt();
		int[] tcase = new int[t];
		int max = 0;
		for(int i=0; i<t; i++) {
			tcase[i] = sc.nextInt();
			max = Math.max(max, tcase[i]);
		}
		check(max);
		
		long answer = 0;
		for(int i=0; i<t; i++) {
			answer = (dp[tcase[i]][1] + dp[tcase[i]][2] + dp[tcase[i]][3]) % 1000000009;
			sb.append(answer + "\n");
		}
		sc.close();
		System.out.println(sb);
	}

	public static void check(int max) {
		for(int j=4; j<=max; j++) {
			dp[j][1] = (dp[j-1][2] + dp[j-1][3]) % 1000000009;
			dp[j][2] = (dp[j-2][1] + dp[j-2][3]) % 1000000009;
			dp[j][3] = (dp[j-3][1] + dp[j-3][2]) % 1000000009;
		}
	}
}
