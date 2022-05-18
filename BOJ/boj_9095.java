package BOJ;

import java.util.Scanner;

/*
 * 2022.05.18 daily algo/commit
 * 
 * Brute Force 
 * n <= 10 �̱⶧���� �ִ� n�� �� 3^10 �̸� n�� for������ Ǯ�̰� �����ϴ�.
 * ����Լ��� �̿��Ͽ� �ݺ��Ǵ� �ڵ带 ���� �� �ִ�.
 * 
 * ������Լ� ��� �� ���� �ʱ�ȭ�� ������!
 */

public class boj_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			cnt = 0;
			for(int j=1; j<=n; j++) {
				calculation(j, n, 0, 0);
			}
			System.out.println(cnt);
		}
		sc.close();
	}

	static int cnt;
	public static void calculation(int j, int n, int start, int sum) {
		if(start == j) {
			if(sum == n) cnt += 1;
			return;
		}
		for(int k=1; k<=3; k++) {
			calculation(j, n, start+1, sum+k);
		}
	}
}
