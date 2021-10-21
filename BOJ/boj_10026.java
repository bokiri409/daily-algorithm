package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.10.19 daily algo/commit
 * 
 * ���� - ���ϻ��� gold5 BFS/DFS
 */

public class boj_10026 {
	
	static int y = 0;
	static int n = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		char[][] bgrid = new char[N][N]; // ���� �׸��� 
		char[][] grid = new char[N][N]; // �׸���
		visited = new boolean[N][N]; // �׸��� �湮üũ
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String color = st.nextToken();
			for(int j=0; j<N; j++) {
				grid[i][j] = color.charAt(j);
				if(color.charAt(j) == 'G') {
					bgrid[i][j] = 'R'; // ������ ����� ��� R�� ǥ��
				}
				else {
					bgrid[i][j] = color.charAt(j);
				}
			}
		}
		
		// 1. ���ϻ��� ���� �Ǻ�
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					char color = bgrid[i][j];
					colorBlind(color, i, j, bgrid, N, visited); // ����
					y += 1;
				}
			}
		}
		
		// 2. �Ϲ� ���� �Ǻ�
		visited = new boolean[N][N]; // �湮üũ �ʱ�ȭ
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					char color = grid[i][j];
					nonColorBlind(color, i, j, grid, N, visited); // ����
					n += 1;
				}
			}
		}
		
		System.out.println(n + " " + y);
	}
	
	public static void colorBlind(char color, int i, int j, char[][] bgrid, int N, boolean[][] visited) {
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			if(i+dx[k] >= 0 && i+dx[k] < N && j+dy[k] >= 0 && j+dy[k] < N) {
				if(!visited[i+dx[k]][j+dy[k]] && bgrid[i+dx[k]][j+dy[k]] == color) {
					colorBlind(color, i+dx[k], j+dy[k], bgrid, N, visited);
				}
			}
		}
	}
	
	public static void nonColorBlind(char color, int i, int j, char[][] grid, int N, boolean[][] visited) {
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			if(i+dx[k] >= 0 && i+dx[k] < N && j+dy[k] >= 0 && j+dy[k] < N) {
				if(!visited[i+dx[k]][j+dy[k]] && grid[i+dx[k]][j+dy[k]] == color) {
					nonColorBlind(color, i+dx[k], j+dy[k], grid, N, visited);
				}
			}
		}
	}
	
}
