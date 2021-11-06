package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.11.06 daily algo/commit
 * 
 * bfs로 최단거리를 구할 수 있지만 시간초과가 났다.
 * => 큐를 이용하여 길을 큐에 넣을 때 중복된 길을 넣는 경우가 생긴다.
 * 	  중복된 길을 방문체크하여 빼준다면 효율성을 높일 수 있다. !
 */

public class prg_2B_게임맵최단거리 {
	
//	static int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
	static int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;

	public static void main(String[] args) {
		System.out.println(solution(maps));
	}
	
	public static int solution(int[][] maps) {
        int n = maps.length; // 행의 길이
        int m = maps[0].length; // 열의 길이
        
        return bfs(maps, n, m);
    }
	
	public static int bfs(int[][] maps, int n, int m) {
		Queue<Location> q = new LinkedList<Location>();
		visited = new boolean[n][m];
		int cur_x = 0;
		int cur_y = 0;
		int cur_move = 1; // 현재까지 이동 거리
		q.add(new Location(cur_x, cur_y, cur_move));
		
		while(!q.isEmpty()) {
			Location location = (Location) q.poll();
			cur_x = location.x;
			cur_y = location.y;
			cur_move = location.move;
			System.out.println(cur_x + " " + cur_y);
			
			// 방문 체크 // 지나간 길은 0으로 만들어 준다.
			maps[cur_x][cur_y] = 0; 
			visited[cur_x][cur_y] = true;
			
			for(int i=0; i<4; i++) {
				if(cur_x + dx[i] >= 0 && cur_x + dx[i] < n && cur_y + dy[i] >= 0 && cur_y + dy[i] < m && !visited[cur_x + dx[i]][cur_y + dy[i]]) { // 맵의 범위 안에 있을 때
					// 갈 수 있는 길일 때
					if(maps[cur_x+dx[i]][cur_y+dy[i]] == 1) {
						if(cur_x+dx[i] == n-1 && cur_y+dy[i] == m-1) { // 상대팀 진영에 도착 시
							cur_move += 1;
							return cur_move;
						}
						visited[cur_x + dx[i]][cur_y + dy[i]] = true;
						q.add(new Location(cur_x+dx[i], cur_y+dy[i], cur_move+1));
					}
				}
			}
		}
		
		return -1;
	}
	
	// 나의 위치정보, 현재까지 이동거리 
	public static class Location {
		int x, y, move;
		
		public Location(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

}
