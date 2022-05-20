package BOJ;

import java.util.Scanner;

/*
 * 2022.05.20 daily algo/commit
 * 
 * Brute Force/combination
 */

public class boj_15650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
//		boolean[] visited = new boolean[N+1];
		int[] arr = new int[M];
		select(N, M, 0, 1, arr);
		System.out.print(sb);
		sc.close();
	}

	static StringBuilder sb = new StringBuilder();
	public static void select(int n, int m, int start, int depth, int[] arr) {
		if(start == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		// depth를 설정해주면 visited를 사용할 필요가 없다.
		for(int i=depth; i<=n; i++) {
			arr[start] = i;
			select(n, m, start+1, i+1, arr);
//			if(!visited[i]) {
//				arr[start] = i;
//				visited[i] = true;
//				select(n, m, start+1, i+1, arr, visited);
//				visited[i] = false;
//			}
		}
	}
}
