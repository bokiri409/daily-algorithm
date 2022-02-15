package BOJ;

import java.util.Scanner;

/*
 * 2021.02.15 daily algo/commit
 * 
 * Brute Force
 * (x, y)의 B시작과 W시작으로 모든 경우를 체크해서 최소값 출력
 */

public class boj_1018 {
	
	static int min = 64;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[][] chess = new String[N][M];
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<M; j++) {
				chess[i][j] = line.substring(j, j+1);
			}
		}
		sc.close();
		
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				// 시작시점
				make(i, j, chess);
			}
		}
		System.out.println(min);
	}
	
	public static void make(int x, int y, String[][] chess) {
		int paint = 0;
		// B기준
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(!chess[x+2*i][y+2*j].equals("B")) paint += 1;
				if(!chess[x+2*i+1][y+2*j+1].equals("B")) paint += 1;
				if(!chess[x+2*i][y+2*j+1].equals("W")) paint += 1;
				if(!chess[x+2*i+1][y+2*j].equals("W")) paint += 1;
			}
		}
		min = Math.min(min, paint);
		
		paint = 0;
		// W기준
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(!chess[x+2*i][y+2*j].equals("W")) paint += 1;
				if(!chess[x+2*i+1][y+2*j+1].equals("W")) paint += 1;
				if(!chess[x+2*i][y+2*j+1].equals("B")) paint += 1;
				if(!chess[x+2*i+1][y+2*j].equals("B")) paint += 1;
			}
		}
		min = Math.min(min, paint);
	}

}
