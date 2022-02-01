package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.02.02 daily algo/commit
 * 
 * DP
 * LCS(Longest Commen Subsequence) : 최장 공통 부분수열
 * 참고블로그 : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
 * 
 */

public class boj_1695 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N+1];
		int[] de_num = new int[N+1];
		for(int i=1; i<=N; i++) {
			num[i] = de_num[N-i+1] = sc.nextInt();
		}
		sc.close();
		
		int[][] dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				// 앞, 뒤가 다를 때
				if(num[i] != de_num[j]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				else {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
			}
		}
		
		System.out.println(N-dp[N][N]);
	}

}
