package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.06.15 daily algo/commit
 * 
 * Brute Force/Combination
 */

public class boj_14889 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] ability = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ability[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		boolean[] team = new boolean[N];
		for(int i=1; i<N; i++) {
			combination(i, N, 0, team, ability);
		}
		
		System.out.println(min);
	}

	static int min = Integer.MAX_VALUE;
	public static void combination(int r, int n, int s, boolean[] team, int[][] ability) {
		if(r == 0) {
			System.out.println(Arrays.toString(team));
			int start = 0;
			int link = 0;
			for(int i=0; i<team.length; i++) {
				if(team[i]) {
					for(int j=i+1; j<team.length; j++) {
						if(team[j]) {
							start += ability[i][j] + ability[j][i];
						}
					}
				}
				else {
					for(int j=i+1; j<team.length; j++) {
						if(!team[j]) {
							link += ability[i][j] + ability[j][i];
						}
					}
				}
			}
			min = Math.min(min, Math.abs(start-link));
			return;
		}
		for(int i=s; i<n; i++) {
			team[i] = true;
			combination(r-1, n, i+1, team, ability);
			team[i] = false;
		}
	}
}
