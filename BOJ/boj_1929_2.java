package BOJ;

import java.util.Scanner;

/*
 * 2022.05.10 daily algo/commit
 * 
 * 소수 구하기 - 에라토스테네스의 체
 * 2부터 주어진 수 중 큰 수인 N까지 배열을 만들어 미리 소수 판별을 해놓는다.
 */

public class boj_1929_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		// 2부터 에라토스테네스 체의 원리를 이용하여 소수만 걸러준다.
		boolean[] primes = new boolean[N+1];
		primes[0] = primes[1] = true;
		for(int i=2; i*i<=N; i++) {
			if(primes[i]) continue;
			for(int j=2; i*j<=N; j++) {
				primes[i*j] = true; // 소수X
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(!primes[i]) sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}

}
