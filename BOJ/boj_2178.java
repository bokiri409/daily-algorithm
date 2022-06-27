package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.06.27 daily algorithm
 * 
 * BFS - 최단거리 구하기
 */

public class boj_2178 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		
		System.out.println(bfs(0, 0, n-1, m-1));
	}

	static boolean[][] visited;
	public static int bfs(int x, int y, int destX, int destY) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 1));
		visited[x][y] = true;
		int cnt = 0;
		
		loop:
		while(!queue.isEmpty()) {
			x = queue.peek().x;
			y = queue.peek().y;
			cnt = queue.peek().cnt;
			queue.poll();
			
			for(int i=0; i<4; i++) {
				if(x+dx[i] < 0 || x+dx[i] >= n || y+dy[i] < 0 || y+dy[i] >= m) continue;
				if(!visited[x+dx[i]][y+dy[i]]) {
					visited[x+dx[i]][y+dy[i]] = true;
					if(x+dx[i] == destX && y+dy[i] == destY) break loop;
					if(map[x+dx[i]][y+dy[i]] == 0) continue;
					queue.add(new Point(x+dx[i], y+dy[i], cnt+1));
				}
			}
		}
		return cnt+1;
	}
	
	
	static class Point {
		int x, y, cnt;
		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}

