package BOJ;

import java.util.Scanner;

/*
 * 2021.12.11 daily algo/commit
 * 
 * Brute Force, Combination
 */

public class boj_16938 {
	
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		int X = sc.nextInt();
		int[] difficulty = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			difficulty[i] = sc.nextInt();
		}
		
		// i는 선택한 문제 수
		for(int i=2; i<=N; i++) {
			combination(difficulty, visited, N, i, 0, L, R, X);
		}
		
		System.out.println(answer);
		sc.close();
	}

	public static void combination(int[] difficulty, boolean[] visited, int n, int r, int start, int L, int R, int X) {
		if(r == 0) {
			int sum = 0;
			int max = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					if(max < difficulty[i]) max = difficulty[i];
					if(min > difficulty[i]) min = difficulty[i];
					sum += difficulty[i];
				}
			}
			if(sum >= L && sum <= R && max - min >= X) answer += 1;
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(difficulty, visited, n, r-1, i+1, L, R, X);
			visited[i] = false;
		}
	}
}
