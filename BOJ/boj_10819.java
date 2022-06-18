package BOJ;

import java.util.Scanner;

/*
 * 2022.06.18 daily algorithm
 * 
 * Brute Force/Permutation
 */

public class boj_10819 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] numbers = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		sc.close();
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		permutation(N, 0, numbers, arr, visited);
		
		System.out.println(max);
	}

	
	public static void permutation(int n, int start, int[] numbers, int[] arr, boolean[] visited) {
		if(start == n) {
//			System.out.println(Arrays.toString(arr));
			calculation(arr);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				arr[start] = numbers[i];
				visited[i] = true;
				permutation(n, start+1, numbers, arr, visited);
				visited[i] = false;
			}
		}
	}
	
	static int max = 0;
	public static void calculation(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length-1; i++) {
			sum += Math.abs(arr[i] - arr[i+1]);
		}
		max = Math.max(sum, max);
	}
}
