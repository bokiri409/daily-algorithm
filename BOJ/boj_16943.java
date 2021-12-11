package BOJ;

import java.util.Scanner;

/*
 * 2021.12.11 daily algo/commit
 * 
 * Brute Force, Permutation
 */

public class boj_16943 {
	
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		int B = sc.nextInt();
		
		int[] nums = new int[A.length()];
		int[] arr = new int[A.length()];
		boolean[] visited = new boolean[A.length()];
		for(int i=0; i<A.length(); i++) {
			nums[i] = A.charAt(i) - '0';
		}
		
		permutation(nums, arr, visited, A.length(), 0, B);
		System.out.println(max);
		
		sc.close();
	}
	
	public static void permutation(int[] nums, int[] arr, boolean[] visited, int n, int depth, int B) {
		if(depth == n) {
			int num = 0;
			if(arr[0] == 0) return;
			for(int i=0; i<n; i++) {
				num += arr[i] * Math.pow(10, n-i-1);
			}
			if(num > B) return;
			if(max < num) max = num;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];
				permutation(nums, arr, visited, n, depth+1, B);
				visited[i] = false;
			}
		}
	}

}
