package BOJ;

import java.util.Scanner;

/*
 * 2022.06.25 daily algorithm
 * 
 * DP
 * 연속된 합이 가장 큰 부분수열 찾기 
 * dp[n] : n-1 ~ 0까지 가장 큰 수의 합(연속된)과 arr[n]과 합한 수와 arr[n]을 비교하여 큰 수  
 */

public class boj_1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		int max = dp[0];
		for(int i=1; i<n; i++) { // arr
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
