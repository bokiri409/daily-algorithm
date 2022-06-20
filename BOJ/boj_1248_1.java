package BOJ;

import java.util.Scanner;

/*
 * 2022.06.20 daily algorithm
 * 
 * time complexity improvement
 * combination으로 배열을 미리 구하고 검사하면 경우의 수가 너무 많기 때문에 각각의 수를 하나씩 검사하면서 진행하는 것이 경우의 수를 줄일 수 있다.
 * 재귀함수를 이용하여 배열의 수를 찾으면서 해당 수가 맞으면 t, 틀리면 f로 return한다.
 */

public class boj_1248_1 {
	
	static int n;
	static int[][] sign;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sign = new int[n][n];
		arr = new int[n];
		String str = sc.next();
		
		int start = 0;
		int end = n;
		for(int i=0; i<n; i++) {
			String s = str.substring(start, end);
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == '+') sign[i][i+j] = 1;
				else if(s.charAt(j) == '-') sign[i][i+j] = -1;
				else sign[i][i+j] = 0;
			}
			start = end;
			end += (n-i-1);
		}
		sc.close();
		
		search(0);
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static boolean search(int index) {
		if(index == n) {
			return true;
		}
		// 0인 경우
		if(sign[index][index] == 0) {
			arr[index] = 0;
			return check(index) && search(index + 1);
		}
		// +이거나 - 경우
		for(int i=1; i<=10; i++) {
			arr[index] = i * sign[index][index];
			if(check(index) && search(index+1)) return true;
		}
		return false;
	}
	
	public static boolean check(int index) {
		int sum = 0;
		for(int i=index; i>=0; i--) {
			sum += arr[i];
			if(sum > 0 && sign[i][index] <= 0) return false;
			else if(sum < 0 && sign[i][index] >= 0) return false;
			else if(sum == 0 && sign[i][index] != 0) return false;
		}
		return true;
	}
}
