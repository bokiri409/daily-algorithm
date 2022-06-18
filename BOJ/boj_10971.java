package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.06.18 daily algorithm
 * 
 * Brute Force/Permutation
 * 외판원 순회 - Traveling Salesman problem (TSP)
 * 경우의 수 : N!가
 * 시간복잡도 : O(N * N!)
 * 
 * ex. 
 * 1,2,3,4
 * 2,3,4,1
 * 3,4,1,2
 * 4,1,2,3
 * 4가지 경우 모두 같은 경우이다. (시작 도시로 돌아가야 하기 때문에)
 * => 따라서 시작점을 0으로 고정한 뒤에 나머지 도시만 순열을 돌려줘도 같은 값이 된다.
 * => 경우의 수 : N!/N = (N-1)!
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
		sc.close();
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		arr[0] = 0;
		permutation(N, 1, map, arr, visited);
		System.out.println(min);
	}
	
	public static void permutation(int n, int start, int[][] map, int[] arr, boolean[] visited) {
		if(start == n) {
			System.out.println(Arrays.toString(arr));
			travel(arr, map);
			return;
		}
		for(int i=1; i<n; i++) {
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
