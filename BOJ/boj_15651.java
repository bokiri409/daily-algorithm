package BOJ;

import java.util.Scanner;

/*
 * 2022.05.24 daily algo/commit
 * 
 * 출력하는데 시간이 많이 쓰임
 */

public class boj_15651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		
		int[] arr = new int[M];
		combination(N, M, 1, arr);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();
	public static void combination(int n, int r, int start, int[] arr) {
		if(r == 0) {
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]+" ");
//				System.out.print(arr[i] + " ");
			}
//			System.out.println();
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			arr[start-1] = i;
			combination(n, r-1, start+1, arr);
		}
	}
}
