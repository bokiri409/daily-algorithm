package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.06.29 daily algorithm
 * 
 * BFS - 최단시간 구하기
 */

public class boj_7576 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] box = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1) {
					queue.add(new Point(i, j, 0));
				}
			}
		}
		sc.close();
		
		tomato(box, n, m);
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 0) day = -1;
			}
		}
		
		System.out.println(day);
	}

	static int day = 0;
	static Queue<Point> queue = new LinkedList<>();
	public static void tomato(int[][] box, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			int dist = queue.peek().dist;
			day = Math.max(day, dist);
			queue.poll();
			visited[x][y] = true;
			
			for(int i=0; i<4; i++) {
				if(x+dx[i] >= n || x+dx[i] < 0 || y+dy[i] >= m || y+dy[i] < 0) continue;
				if(!visited[x+dx[i]][y+dy[i]] && box[x+dx[i]][y+dy[i]] == 0) {
					visited[x+dx[i]][y+dy[i]] = true;
					box[x+dx[i]][y+dy[i]] = 1;
					queue.add(new Point(x+dx[i], y+dy[i], dist+1));
				}
			}
		}
	}
	
	static class Point {
		int x, y, dist = 0;
		Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
