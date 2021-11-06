package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.11.06 daily algo/commit
 * 
 * bfs�� �ִܰŸ��� ���� �� ������ �ð��ʰ��� ����.
 * => ť�� �̿��Ͽ� ���� ť�� ���� �� �ߺ��� ���� �ִ� ��찡 �����.
 * 	  �ߺ��� ���� �湮üũ�Ͽ� ���شٸ� ȿ������ ���� �� �ִ�. !
 */

public class prg_2B_���Ӹ��ִܰŸ� {
	
//	static int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
	static int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;

	public static void main(String[] args) {
		System.out.println(solution(maps));
	}
	
	public static int solution(int[][] maps) {
        int n = maps.length; // ���� ����
        int m = maps[0].length; // ���� ����
        
        return bfs(maps, n, m);
    }
	
	public static int bfs(int[][] maps, int n, int m) {
		Queue<Location> q = new LinkedList<Location>();
		visited = new boolean[n][m];
		int cur_x = 0;
		int cur_y = 0;
		int cur_move = 1; // ������� �̵� �Ÿ�
		q.add(new Location(cur_x, cur_y, cur_move));
		
		while(!q.isEmpty()) {
			Location location = (Location) q.poll();
			cur_x = location.x;
			cur_y = location.y;
			cur_move = location.move;
			System.out.println(cur_x + " " + cur_y);
			
			// �湮 üũ // ������ ���� 0���� ����� �ش�.
			maps[cur_x][cur_y] = 0; 
			visited[cur_x][cur_y] = true;
			
			for(int i=0; i<4; i++) {
				if(cur_x + dx[i] >= 0 && cur_x + dx[i] < n && cur_y + dy[i] >= 0 && cur_y + dy[i] < m && !visited[cur_x + dx[i]][cur_y + dy[i]]) { // ���� ���� �ȿ� ���� ��
					// �� �� �ִ� ���� ��
					if(maps[cur_x+dx[i]][cur_y+dy[i]] == 1) {
						if(cur_x+dx[i] == n-1 && cur_y+dy[i] == m-1) { // ����� ������ ���� ��
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
	
	// ���� ��ġ����, ������� �̵��Ÿ� 
	public static class Location {
		int x, y, move;
		
		public Location(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

}
