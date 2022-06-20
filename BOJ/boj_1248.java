package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.06.19 daily algorithm
 */

public class boj_1248 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char[][] matrix = new char[n+1][n+1];
		String str = sc.next();
		
		int start = 0;
		int end = n;
		for(int i=1; i<=n; i++) {
			String s = str.substring(start, end);
			System.out.println(s);
			for(int j=0; j<s.length(); j++) {
				matrix[i][j+i] = s.charAt(j);
			}
			start = end;
			end += (n-i);
		}
		sc.close();
		
		boolean[][] visited = new boolean[n+1][11];
		int[] arr = new int[n];
		search(n+1, n, 1, matrix, visited, arr);
	}
	
	static boolean flag = false;
	public static void search(int r, int n, int start, char[][] matrix, boolean[][] visited, int[] arr) {
		if(flag) return;
		if(start == r) {
			System.out.println(Arrays.toString(arr));
			if(check(arr, n, matrix)) {
				for(int i : arr) {
					System.out.print(i + " ");
				}
				flag = true;
			}
			return;
		}
		for(int j=1; j<=10; j++) {
			if(!visited[start][j]) {
				if(matrix[start][start] == '-') arr[start-1] = -j;
				else if(matrix[start][start] == '+') arr[start-1] = j;
				else arr[start-1] = 0;
				
				visited[start][j] = true;
				search(r, n, start+1, matrix, visited, arr);
				visited[start][j] = false;
			}
		}
	}
	
	public static boolean check(int[] arr, int n, char[][] matrix) {
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum += arr[k-1];
				}
				
				if(sum > 0 && (matrix[i][j] == '-' || matrix[i][j] == '0')) return false;
				else if(sum < 0 && (matrix[i][j] == '+' || matrix[i][j] == '0')) return false;
				else if(sum == 0 && (matrix[i][j] == '+' || matrix[i][j] == '-')) return false;
			}
		}
		return true;
	}

}
