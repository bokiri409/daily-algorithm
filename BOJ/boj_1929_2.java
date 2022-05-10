package BOJ;

import java.util.Scanner;

/*
 * 2022.05.10 daily algo/commit
 * 
 * �Ҽ� ���ϱ� - �����佺�׳׽��� ü
 * 2���� �־��� �� �� ū ���� N���� �迭�� ����� �̸� �Ҽ� �Ǻ��� �س��´�.
 */

public class boj_1929_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		// 2���� �����佺�׳׽� ü�� ������ �̿��Ͽ� �Ҽ��� �ɷ��ش�.
		boolean[] primes = new boolean[N+1];
		primes[0] = primes[1] = true;
		for(int i=2; i*i<=N; i++) {
			if(primes[i]) continue;
			for(int j=2; i*j<=N; j++) {
				primes[i*j] = true; // �Ҽ�X
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(!primes[i]) sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}

}
