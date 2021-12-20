package BOJ;

import java.util.Scanner;

/*
 * 2021.12.20 daily algo/commit
 * 
 * Brute Force
 * 1,2번째 수에 어떻게 적용할 지만 알면 3번째부터는 정해지므로 (+1, -1, 0) 3^2가지 경우만 생각하면 된다.
 */

public class boj_17088 {
	
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] B = new int[N];
		int[] b = new int[N-1]; // 차이 배열
		for(int i=0; i<N; i++) {
			B[i] = sc.nextInt();
		}
		sc.close();
		
		if(B.length == 1) {
			System.out.println(0);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			b[i] = Math.abs(B[i]-B[i+1]);
			// 차이가 4 이상이면 등차수열 불가능
			if(i > 0 && Math.abs(b[i-1]-b[i]) > 4) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int i=-1; i<=1; i++) {
			for(int j=-1; j<=1; j++) {
				int cnt = 0;
				int[] BB = B.clone();
				BB[0] += i; // 첫 번째 수
				BB[1] += j; // 두 번째 수
				if(i != 0) cnt += 1;
				if(j != 0) cnt += 1;
				int ans = check(BB, BB[1]-BB[0], 0);
				if(ans == -1) continue;
				ans += cnt;
				if(min > ans) min = ans;
			}
		}
		System.out.println(min);
	}

	public static int check(int[] BB, int d, int cnt) {
		for(int i=1; i<BB.length-1; i++) {
			int diff = BB[i+1] - BB[i];
			if(diff != d) {
				if(Math.abs(diff-d) > 1) return -1;
				BB[i+1] += (d-diff);
				cnt += 1;
			}
		}
		return cnt;
	}
}
