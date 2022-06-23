package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.06.23 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * 추가된 조건을 점화식에 넣을 수 있는지 체크하고 점화식으로 표현해본다. 
 * 
 * dp[n] : n까지의 만들 수 있는 부분 수열 중 가장 긴 길이
 * dp[n] = dp[n-1] < dp[n] 일 때, Math.max(dp[0], dp[1], ... , dp[n-1]) + 1
 */

public class boj_11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int max = 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for(int i=0; i<n; i++) {
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

}
