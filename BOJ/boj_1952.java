package BOJ;

import java.util.Scanner;

/*
 * 2021.01.12 daily algo/commit
 * 
 * Brute Force
 */

public class boj_1952 {
	
	static int n, m, x, y, num;
	static int[][] snail;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		snail = new int[n][m];

		snail[x][y] = 1;
		int idx = 0;
		int ban = 0; // 못가는 경우
		while(true) {
			if(x+dx[idx] >= 0 && x+dx[idx] < n && y+dy[idx] >= 0 && y+dy[idx] < m && snail[x+dx[idx]][y+dy[idx]] == 0) {
				x += dx[idx];
				y += dy[idx];
				snail[x][y] = 1;
				ban = 0;
			}
			else {
				idx += 1;
				if(idx >= 4) idx = 0;
				ban += 1;
				if(ban == 4) break;
				if(ban <= 1) num += 1; // 꺾는 수
			}
		}
		System.out.println(num-1);
//		for(int i=0; i<4; i++) {
//			x += dx[i];
//			y += dy[i];
//			while(snail[x][y] == 0 && x >= 0 && x < n && y >= 0 && y < m) {
//				snail[x][y] = 1;
//				x += dx[i];
//				y += dy[i];
//			}
//			x -= dx[i];
//			y -= dy[i];
//			if(i >= 4) i = 0;
//			
//		}
	}

}
