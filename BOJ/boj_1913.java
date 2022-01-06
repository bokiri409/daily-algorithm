package BOJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * 2021.01.06 daily algo/commit
 * 
 * 시뮬레이션
 * BufferdWriter를 이용하면 시간을 줄일 수 있다.
 */

public class boj_1913 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; 

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num = sc.nextInt();
		
		sc.close();
		
		int[][] snail = new int[n][n];
		int x = n / 2;
		int y = n / 2;
		snail[x][y] = 1;
		int dir = 0; // 방향
		int layer = 3; // 레이어 인덱스
		int idx = 2; // 넘버링
		while(idx < n*n) {
			// 1. ↑ 1칸
			x += dx[dir];
			y += dy[dir];
			snail[x][y] = idx;
			
			dir += 1;
			// 2. → layer-2칸
			for(int i=0; i<layer-2; i++) {
				idx += 1;
				x += dx[dir];
				y += dy[dir];
				snail[x][y] = idx;
			}
			
			dir += 1;
			// 3. ↓ layer-1칸
			for(int i=0; i<layer-1; i++) {
				idx += 1;
				x += dx[dir];
				y += dy[dir];
				snail[x][y] = idx;
			}
			
			dir += 1;
			// 4. ← layer-1칸
			for(int i=0; i<layer-1; i++) {
				idx += 1;
				x += dx[dir];
				y += dy[dir];
				snail[x][y] = idx;
			}
			
			dir = 0;
			// 5. ↑ layer-1칸
			for(int i=0; i<layer-1; i++) {
				idx += 1;
				x += dx[dir];
				y += dy[dir];
				snail[x][y] = idx;
			}
			idx += 1;
			layer += 2;
		}
		
		int num_x = 0;
		int num_y = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bw.write(snail[i][j] + " ");
				if(snail[i][j] == num) {
					num_x = i + 1;
					num_y = j + 1;
				}
			}
			bw.write("\n");
		}
		bw.flush();
		System.out.println(num_x + " " + num_y);
		
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(snail[i][j] + " ");
				if(snail[i][j] == num) {
					num_x = i + 1;
					num_y = j + 1;
				}
			}
			System.out.println();
		}
		System.out.println(num_x + " " + num_y);
		*/
	}

}
