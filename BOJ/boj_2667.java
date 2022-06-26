package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.06.26 daily algorithm
 * 
 * BFS/DFS
 */

public class boj_2667 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] apart = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<n; j++) {
				apart[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		sc.close();
		
		ArrayList<Integer> house = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && apart[i][j] == 1) {
					house.add(bfs(i, j, apart, visited, n));
				}
			}
		}
		Collections.sort(house);
		
		System.out.println(house.size());
		StringBuilder sb = new StringBuilder();
		for(int i : house) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}

	public static int bfs(int x, int y, int[][] apart, boolean[][] visited, int n) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			x = queue.peek().x;
			y = queue.peek().y;
			queue.poll();
			
			for(int i=0; i<4; i++) {
				if(x+dx[i] < 0 || x+dx[i] >= n || y+dy[i] < 0 || y+dy[i] >= n) continue;
				if(!visited[x+dx[i]][y+dy[i]]) {
					visited[x+dx[i]][y+dy[i]] = true;
					if(apart[x+dx[i]][y+dy[i]] == 1) {
						cnt += 1;
						queue.add(new Point(x+dx[i], y+dy[i]));
					}
				}
			}
		}
		return cnt;
	}
	
}

class Point {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
