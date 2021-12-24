package BOJ;

import java.util.Scanner;

/*
 * 2021.12.25 daily algo/commit
 * 
 * Brute Force
 */

public class boj_17089_2 {
	
	static int min = 4000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] friends = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			friends[a][b] = friends[b][a] = 1;
		}
		
		sc.close();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				// A, B啊 模备老 锭
				if(friends[i][j] == 1) {
					for(int k=1; k<=N; k++) {
						if(friends[j][k] == 1 && friends[k][i] == 1) {
							int cnt = count(friends, i, j, k, 0);
							if(min > cnt) min = cnt;
						}
					}
				}
			}
		}
		
		if(min == 4000) System.out.println(-1);
		else System.out.println(min);
	}
	
	public static int count(int[][] friends, int a, int b, int c, int cnt) {
		for(int j=1; j<friends.length; j++) {
			// 技 模备啊 包拌乐绰 葛电 模备狼 荐
			if(friends[a][j] == 1) cnt += 1;
			if(friends[b][j] == 1) cnt += 1;
			if(friends[c][j] == 1) cnt += 1;
		}
		return cnt - 6; // 技 模备x3 哗林扁
	}
}
