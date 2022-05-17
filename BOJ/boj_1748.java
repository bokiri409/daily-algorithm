package BOJ;

import java.util.Scanner;

/*
 * 2022.05.17 daily algo/commit
 * 
 * Brute Force 
 * ��Ģ ���ؼ� Ǯ��
 * 1~9 : +1
 * 10~99 : +2
 * ..
 * 
 * (9-1+1)*1		+ (99-10+1)*2 + ..
 * 1�ڸ��� ���� * �ڸ���
 */

public class boj_1748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Ǯ��2. ��Ģ�� ã�� ���� ����� �� �� ���� �ڵ带 �� �� �ִ�.
		int N = sc.nextInt();
		long ans = 0;
		for(int start=1, len=1; start<=N; start*=10, len++) {
			int end = start*10-1;
			if(end > N) {
				end = N;
			}
			ans += (end-start+1) * len;
		}
		
		/* Ǯ��1
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
