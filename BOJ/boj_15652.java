package BOJ;

import java.util.Scanner;

/*
 * 2022.05.25 daily algo/commit
 */

public class boj_15652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		
		int[] arr = new int[M];
		combination(N, M, 1, 0, arr);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();
	public static void combination(int n, int r, int start, int depth, int[] arr) {
		if(depth == r) {
			for(int a : arr) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=n; i++) {
			arr[depth] = i;
			combination(n, r, i, depth+1, arr);
		}
	}
}
