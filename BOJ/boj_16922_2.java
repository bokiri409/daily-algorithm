package BOJ;

import java.util.Scanner;

/*
 * 2021.12.01 daily algo/commit
 * 
 * Brute Force
 * 각각의 1,5,10,50을 사용한 개수만 파악하면 된다. 
 * 넷중 세개의 개수만 알면 나머지 하나도 알 수 있으므로 3중 for문을 이용하여 간단하게 풀이 가능하다.
 */

public class boj_16922_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] visited = new boolean[1001];
		
		int answer = 0;
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N-i; j++) {
				for(int k=0; k<=N-i-j; k++) {
					int l = N-i-j-k;
					int sum = i+j*5+k*10+l*50;
					if(!visited[sum]) {
						visited[sum] = true;
						answer += 1;
					}
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
