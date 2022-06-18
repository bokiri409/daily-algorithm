package BOJ;

import java.util.Scanner;

/*
 * 2022.06.18 daily algorithm
 * 
 * Brute Force/Combination
 */

public class boj_6603 {
	
	static final int select = 6;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int k = sc.nextInt();
			if(k == 0) break;
			int[] S = new int[k];
			for(int i=0; i<k; i++) {
				S[i] = sc.nextInt();
			}
			
			int[] arr = new int[select];
			combination(0, k, 0, S, arr);
			sb.append("\n");
		}
		sc.close();
		System.out.println(sb);
	}

	public static void combination(int r, int n, int start, int[] S, int[] arr) {
		if(r == select) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<n; i++) {
			arr[r] = S[i];
			combination(r+1, n, i+1, S, arr);
		}
	}
}
