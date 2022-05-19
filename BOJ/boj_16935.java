package BOJ;

import java.util.Scanner;

/*
 * 2022.05.19 daily algo/commit
 * 
 * Simulation
 * 배열 재설정
 */

public class boj_16935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<R; i++) {
			int r = sc.nextInt();
			int n = map.length; // 행
			int m = map[0].length; // 열
			if(r == 1) map = cal1(r, map, n, m);
			else if(r == 2) map = cal2(r, map, n, m);
			else if(r == 3) map = cal3(r, map, n, m);
			else if(r == 4) map = cal4(r, map, n, m);
			else if(r == 5) map = cal5(r, map, n, m);
			else map = cal6(r, map, n, m);
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 1번 연산: 상하반전
	public static int[][] cal1(int r, int[][] map, int n, int m) {
		int[][] remap = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				remap[i][j] = map[n-1-i][j];
			}
		}
		return remap;
	}
	
	// 2번 연산: 좌우반전
	public static int[][] cal2(int r, int[][] map, int n, int m){
		int[][] remap = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				remap[i][j] = map[i][m-1-j];
			}
		}
		return remap;
	}		
	
	// 3번 연산: 오른쪽 90도 회전
	public static int[][] cal3(int r, int[][] map, int n, int m){
		int[][] remap = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				remap[i][j] = map[n-1-j][i];
			}
		}
		return remap;
	}
	
	// 4번 연산: 왼쪽 90도 회전
	public static int[][] cal4(int r, int[][] map, int n, int m){
		int[][] remap = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				remap[i][j] = map[j][m-1-i];
			}
		}
		return remap;
	}
	
	// 5번 연산: 1->2->3->4
	public static int[][] cal5(int r, int[][] map, int n, int m){
		int[][] remap = new int[n][m];
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				remap[i][j+m/2] = map[i][j]; // 1->2
				remap[i+n/2][j+m/2] = map[i][j+m/2]; // 2->3
				remap[i+n/2][j] = map[i+n/2][j+m/2]; // 3->4
				remap[i][j] = map[i+n/2][j]; // 4->1
			}
		}
		return remap;
	}
	
	// 6번 연산: 1->4->3->2
	public static int[][] cal6(int r, int[][] map, int n, int m){
		int[][] remap = new int[n][m];
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				remap[i+n/2][j] = map[i][j]; // 1->4
				remap[i+n/2][j+m/2] = map[i+n/2][j]; // 4->3
				remap[i][j+m/2] = map[i+n/2][j+m/2]; // 3->2
				remap[i][j] = map[i][j+m/2]; // 2->1
			}
		}
		return remap;
	}
}
