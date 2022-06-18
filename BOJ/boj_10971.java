package BOJ;

import java.util.Scanner;

/*
 * 2022.06.18 daily algorithm
 * 
 * Brute Force/Permutation
 * 외판원 순회 - Traveling Salesman problem (TSP)
 */

public class boj_10971 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		permutation(N, 0, map, arr, visited);
		System.out.println(min);
	}
	
	public static void permutation(int n, int start, int[][] map, int[] arr, boolean[] visited) {
		if(start == n) {
//			System.out.println(Arrays.toString(arr));
			travel(arr, map);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				arr[start] = i;
				visited[i] = true;
				permutation(n, start+1, map, arr, visited);
				visited[i] = false;
			}
		}
	}

	static long min = Long.MAX_VALUE;
	public static void travel(int[] arr, int[][] map) {
		int dest = arr[0]; // destination
		long cost = 0;
		if(map[arr[arr.length-1]][dest] == 0) return;
		for(int i=0; i<arr.length-1; i++) {
			if(map[arr[i]][arr[i+1]] == 0) return;
			cost += map[arr[i]][arr[i+1]];
		}
		cost += map[arr[arr.length-1]][dest];
		min = Math.min(min, cost);
	}
}
