package BOJ;

import java.util.Scanner;

/*
 * 2022.02.20 daily algo/commit
 */

public class boj_2579 {
	
	static int n, max = 0;
	static int[] stairs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		stairs = new int[n];
		for(int i=0; i<n; i++) {
			stairs[i] = sc.nextInt();
		}
		sc.close();
		if(n > 1) System.out.println(walk(n-1));
		else System.out.println(stairs[0]);
	}
	
	public static int walk(int pos) {
		int[] score = new int[n];
		int[] scoreN = new int[n]; // 연속 계단 점수
		
		score[pos] = stairs[pos];
		scoreN[pos-1] = stairs[pos-1] + score[pos];
		for(int i=n-3; i>=0; i--) {
			score[i] = stairs[i] + score[i+2];
			if(score[i+1] > 0) {
				if(score[i] < stairs[i] + score[i+1]) {
					scoreN[i] = stairs[i] + score[i+1];
				}
			}
			if(scoreN[i+2] > 0) {
				score[i] = Math.max(score[i], stairs[i] + scoreN[i+2]);
			}
		}
		max = Math.max(Math.max(Math.max(score[0], score[1]), scoreN[0]), scoreN[1]);
		return max;
	}

}
