package BOJ;

import java.util.Scanner;

/*
 * 2022.05.05 daily algo/commit
 * Math
 * ȿ������ �ð����⵵�� �� ��������.
 */

public class boj_17427 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// int���� ������ �ȵǼ� long�� ������Ѵ�.!
		long sum = 0;
		for(int i=1; i<=n; i++) {
			sum += (i*(n/i));
		}
		
		
		/*
		 * �ð� ���⵵�� 10��~ 3�ð� ������ ������ ��� ���� �� ���غ� �� ����.
		int sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=Math.sqrt(i); j++) {
				if(i % j == 0) { // ����� ��
					if(j != i/j) sum += (j + i/j);
					else sum += j;
				}
			}
		}
		*/
		
		sc.close();
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println(end-start + "ms");
		System.out.println((end-start)/1000.0 + "sec");
	}

}
