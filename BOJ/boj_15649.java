package BOJ;

import java.util.Scanner;

/*
 * 2022.05.20 daily algo/commit
 * 
 * Brute Force
 * ����� �� ��ü�� ���� ������, ��� �� �ð��� ���� �ɸ��Ƿ� StringBuilder�� ����ϸ� ����Ѵ�.
 * System.out.print�� ����ϸ� �ð��ʰ���
 */

public class boj_15649 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] visited = new boolean[N+1];
		int[] arr = new int[M];
		select(N, M, 0, arr, visited);
		System.out.print(sb);
		sc.close();
	}

	static StringBuilder sb = new StringBuilder();
	public static void select(int n, int m, int start, int[] arr, boolean[] visited) {
		if(start == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]+" ");
//				System.out.print(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				arr[start] = i;
				visited[i] = true;
				select(n, m, start+1, arr, visited);
				visited[i] = false;
			}
		}
	}
}
