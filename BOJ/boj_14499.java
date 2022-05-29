package BOJ;

import java.util.Scanner;

/*
 * 2022.05.29 daily algo/commit
 * 
 * Simulation
 */

public class boj_14499 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] move = new int[K];
		for(int i=0; i<K; i++) {
			move[i] = sc.nextInt();
		}
		sc.close();
		int[] dice_row = new int[3];
		int[] dice_col = new int[4];
		
		for(int i=0; i<K; i++) {
			if(move[i] == 1) { // µø
				y += 1;
				if(y >= M) {
					y -= 1;
					continue;
				}
				if(map[x][y] == 0) { // πŸ¥⁄¿Ã 0¿œ ∂ß
					map[x][y] = dice_row[2];
					dice_row[2] = dice_col[3];
					dice_col[3] = dice_row[0];
					dice_row[0] = dice_row[1];
					dice_row[1] = map[x][y];
					dice_col[1] = map[x][y];
				}
				else { // πŸ¥⁄¿Ã 0¿Ã æ∆¥“ ∂ß
					dice_row[2] = dice_col[3];
					dice_col[3] = dice_row[0];
					dice_row[0] = dice_row[1];
					dice_row[1] = map[x][y];
					dice_col[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(dice_col[3]);
			}
			else if(move[i] == 2) { // º≠
				y -= 1;
				if(y < 0) {
					y += 1;
					continue;
				}
				if(map[x][y] == 0) { // πŸ¥⁄¿Ã 0¿œ ∂ß
					map[x][y] = dice_row[0];
					dice_row[0] = dice_col[3];
					dice_col[3] = dice_row[2];
					dice_row[2] = dice_row[1];
					dice_row[1] = map[x][y];
					dice_col[1] = map[x][y];
				}
				else {
					dice_row[0] = dice_col[3];
					dice_col[3] = dice_row[2];
					dice_row[2] = dice_row[1];
					dice_row[1] = map[x][y];
					dice_col[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(dice_col[3]);
			}
			else if(move[i] == 3) { // ∫œ
				x -= 1;
				if(x < 0) {
					x += 1;
					continue;
				}
				if(map[x][y] == 0) { // πŸ¥⁄¿Ã 0¿œ ∂ß
					map[x][y] = dice_col[0];
					dice_col[0] = dice_col[3];
					dice_col[3] = dice_col[2];
					dice_col[2] = dice_col[1];
					dice_col[1] = map[x][y];
					dice_row[1] = map[x][y];
				}
				else {
					dice_col[0] = dice_col[3];
					dice_col[3] = dice_col[2];
					dice_col[2] = dice_col[1];
					dice_col[1] = map[x][y];
					dice_row[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(dice_col[3]);
			}
			else { // ≥≤
				x += 1;
				if(x >= N) {
					x -= 1;
					continue;
				}
				if(map[x][y] == 0) { // πŸ¥⁄¿Ã 0¿œ ∂ß
					map[x][y] = dice_col[2];
					dice_col[2] = dice_col[3];
					dice_col[3] = dice_col[0];
					dice_col[0] = dice_col[1];
					dice_col[1] = map[x][y];
					dice_row[1] = map[x][y];
				}
				else {
					dice_col[2] = dice_col[3];
					dice_col[3] = dice_col[0];
					dice_col[0] = dice_col[1];
					dice_col[1] = map[x][y];
					dice_row[1] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(dice_col[3]);
			}
			
		}
	}
}
