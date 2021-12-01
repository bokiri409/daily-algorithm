package BOJ;

import java.util.Scanner;

/*
 * 2021.12.01 daily algo/commit
 * 
 */

public class boj_16922 {
	
	static int[] numbers = {1,5,10,50};
	static int sum = 0;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		combination(numbers, 0, 0, N);
		
		System.out.println(answer);
		sc.close();
	}
	
	static boolean[] visited = new boolean[1001];
	// idx: 현재 인덱스(0부터 시작)
	public static void combination(int[] numbers, int idx, int cnt, int r) {
		if(cnt == r) {
			if(!visited[sum]) {
				visited[sum] = true;
				answer += 1;
			}
			return;
		}
		for(int i=idx; i<numbers.length; i++) {
			sum += numbers[i];
			System.out.println(i+" "+idx+" "+cnt);
			combination(numbers, i, cnt+1, r);
			sum -= numbers[i];
		}
	}
}
