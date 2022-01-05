package BOJ;

import java.util.Scanner;

/*
 * 2021.01.05 daily algo/commit
 */

public class boj_2798 {
	
	static int m, max;
	static int[] cards;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		m = sc.nextInt();
		
		cards = new int[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			cards[i] = sc.nextInt();
		}
		sc.close();
		
		combination(n, 3, 0, 0);
		System.out.println(max);
	}
	
	public static void combination(int n, int r, int start, int sum) {
		if(r == 0) {
			if(sum <= m) {
				if(max < sum) max = sum;
			}
			return;
		}
		for(int i=start; i<n; i++) {
			visited[i] = true;
			sum += cards[i];
			combination(n, r-1, i+1, sum);
			sum -= cards[i];
			visited[i] = false;
		}
	}

}
