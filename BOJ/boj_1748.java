package BOJ;

import java.util.Scanner;

/*
 * 2022.05.17 daily algo/commit
 * 
 * Brute Force 
 * 규칙 구해서 풀기
 * 1~9 : +1
 * 10~99 : +2
 * ..
 * 
 * (9-1+1)*1		+ (99-10+1)*2 + ..
 * 1자리수 개수 * 자리수
 */

public class boj_1748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 풀이2. 규칙을 찾고 식을 세우는 게 더 좋은 코드를 쓸 수 있다.
		int N = sc.nextInt();
		long ans = 0;
		for(int start=1, len=1; start<=N; start*=10, len++) {
			int end = start*10-1;
			if(end > N) {
				end = N;
			}
			ans += (end-start+1) * len;
		}
		
		/* 풀이1
		int ans = 0;
		int idx = 0;
		for(int i=8; i>=0; i--) {
			int n = (int) Math.pow(10, i);
			int share = N / n;
			if(share > 0) {
				int rest = N % n;
				ans += (((share-1) * n + (rest+1)) * (i+1));
				idx = i;
				break;
			}
		}
		
		for(int i=0; i<idx; i++) {
			int n = (int) Math.pow(10, i);
			ans += (9 * n * (i+1));
		}
		*/
		sc.close();
		System.out.println(ans);
	}

}
