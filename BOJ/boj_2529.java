package BOJ;

import java.util.Scanner;

/*
 * 2022.06.17 daily algorithm
 * 
 * Brute Force
 * 10! = 3628800 = 약 300백
 * 
 * 최초 1회로 검사된 가장 큰 수를 출력하고, 마지막으로 저장된 가장 작은 값을 출력하면 최대/최소를 출력할 수 있다.
 */

public class boj_2529 {
	
	static final int N = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		String[] inequality = new String[k];
		for(int i=0; i<k; i++) {
			inequality[i] = sc.next();
		}
		sc.close();
		
		// 가능한 모든 경우
		int[] arr = new int[k+1];
		boolean[] visited = new boolean[N];
		permutation(k+1, N, 0, arr, visited, inequality);
		System.out.println(ans);
	}
	
	static String ans = "";
	static boolean flag = false; // 최초 1회 검사
	public static void permutation(int r, int n, int start, int[] arr, boolean[] visited, String[] inequality) {
		if(start == r) {
			if(check(arr, inequality)) {
				ans = "";
				for(int i : arr) {
					ans += i;
				}
				if(!flag) {
					System.out.println(ans);
					flag = true;
				}
			}
			return;
		}
		for(int i=n-1; i>=0; i--) {
			if(!visited[i]) {
				arr[start] = i;
				visited[i] = true;
				permutation(r, n, start+1, arr, visited, inequality);
				visited[i] = false;
			}
		}
	}
	
	public static boolean check(int[] arr, String[] inequality) {
		int n = 9;
		for(int i=0; i<inequality.length; i++) {
			if(inequality[i].equals("<")) {
				if(arr[i] > arr[i+1]) return false;
			}
			else {
				if(arr[i] < arr[i+1]) return false;
			}
		}
		return true;
	}
	
}
