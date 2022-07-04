package BOJ;

import java.util.Scanner;

/*
 * 2022.07.04 daily algorithm
 * 
 * Simulation
 * 청소기가 회전하고, 이동하는 순서를 정확히 한다. 
 */

public class boj_14503 {
	
	static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int dir = sc.nextInt();
		int[][] area = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				area[i][j] = sc.nextInt();
				if(area[i][j] == 1) visited[i][j] = true;
			}
		}
		sc.close();
		
		cleaning(area, r, c, dir, visited);
		System.out.println(ans);
	}
	
	static int ans = 1;
	static int cnt = 0;
	public static void cleaning(int[][] area, int r, int c, int dir, boolean[][] visited) {
		visited[r][c] = true;
		
		while(true) {
			// 회전 
			if(dir - 1 < 0) dir = 3;
			else dir -= 1;
			
			if(!visited[r + direction[dir][0]][c + direction[dir][1]]) {
				ans += 1;
				r += direction[dir][0];
				c += direction[dir][1];
				visited[r][c] = true;
				cnt = 0;
				continue;
			}
			
			cnt += 1;
			
			// 4번 연속 회전했을 때
			if(cnt >= 4) {
				int back = 0;
				if(dir == 0 || dir == 1) back = dir + 2;
				else back = dir - 2;
				// 뒤쪽이 벽인 경우 
				if(area[r + direction[back][0]][c + direction[back][1]] == 1) return;
				// 벽 아닌 경우 1칸 후진 
				else { 
					r += direction[back][0];
					c += direction[back][1];
					cnt = 0;
				}
			}
			
		}
	}

}
