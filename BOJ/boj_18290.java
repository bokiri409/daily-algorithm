package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.05.28 daily algo/commit
 * 
 * combination
 * 중복선택을 줄여야 시간복잡도를 낮출 수 있다.
 */

public class boj_18290 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] grid = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int[] arr = new int[K];
		boolean[] visited = new boolean[N*M];
		select(N*M, K, 0, arr, visited, grid);
		System.out.println(max);
	}

	public static void select(int n, int r, int start, int[] arr, boolean[] visited, int[][] grid) {
		if(r == 0) {
//			System.out.println(Arrays.toString(arr));
			calculation(arr, grid);
			return;
		}
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[arr.length-r] = i;
				select(n, r-1, i+1, arr, visited, grid);
				visited[i] = false;
			}
		}
	}
	
	static int max = Integer.MIN_VALUE;
	static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void calculation(int[] arr, int[][] grid) {
		int sum = 0;
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] check = new boolean[n][m];
		for(int i=0; i<arr.length; i++) {
			int x = arr[i] / m;
			int y = arr[i] % m;
			
			for(int k=0; k<4; k++) {
				if(x+dir[k][0] < 0 || x+dir[k][0] >= n || y+dir[k][1] < 0 || y+dir[k][1] >= m) continue;
				if(check[x+dir[k][0]][y+dir[k][1]]) return;
			}
			sum += grid[x][y];
			check[x][y] = true;
		}
		
		max = Math.max(max, sum);
		return;
	}
}
