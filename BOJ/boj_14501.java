package BOJ;

import java.util.Scanner;

/*
 * 2022.06.14 daily algo/commit
 * 
 * 일할 수 있는 모든 날을 체크한다. N일동안 각각 일을 하거나/하지 않거나
 * 최대 경우의 수 : 2^15 = 32768가지
 */

public class boj_14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] schedule = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			schedule[i][0] = sc.nextInt();
			schedule[i][1] = sc.nextInt();
		}
		sc.close();
		
		for(int i=1; i<=N; i++) {
			int[] arr = new int[i];
			combination(i, N, 1, arr, schedule);
		}
		
		System.out.println(max);
	}

	static int max = 0;
	public static void combination(int r, int n, int start, int[] arr, int[][] schedule) {
		if(r == 0) {
			max = Math.max(max, work(arr, schedule));
			return;
		}
		for(int i=start; i<=n; i++) {
			arr[arr.length-r] = i;
			combination(r-1, n, i+1, arr, schedule);
		}
	}
	
	
	public static int work(int[] arr, int[][] schedule) {
		int n = schedule.length-1;
		int money = 0;
		int day = arr[0] + schedule[arr[0]][0] - 1;
		if(day > n) return 0;
		for(int i=0; i<arr.length; i++) {
			if(i != 0 && arr[i] <= day) return 0;
			money += schedule[arr[i]][1];
			day = arr[i] + schedule[arr[i]][0] - 1;
			if(day > n) return 0;
		}
		return money;
	}
}
