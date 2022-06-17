package BOJ;

import java.util.Scanner;

/*
 * 2022.06.18 daily algorithm
 * 
 * Brute Force/Permutation
 * 
 * 모든 순열을 구하는 경우의 수 : N!
 * 시간복잡도 : O(N * N!)
 */

public class boj_10974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N+1];
		permutation(N, 0, arr, visited);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();
	public static void permutation(int n, int start, int[] arr, boolean[] visited) {
		if(start == n) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				arr[start] = i;
				visited[i] = true;
				permutation(n, start+1, arr, visited);
				visited[i] = false;
			}
		}
	}
}
