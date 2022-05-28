package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.05.28 daily algo/commit
 */

public class boj_15657 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sc.close();
		
		int[] ans = new int[M];
		permutation(N, M, 0, arr, ans);
		System.out.print(sb);
	}

	static StringBuilder sb = new StringBuilder();
	public static void permutation(int n, int r, int depth, int[] arr, int[] ans) {
		if(depth == r) {
			for(int a : ans) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			ans[depth] = arr[i];
			permutation(n, r, depth+1, arr, ans);
		}
	}
}
