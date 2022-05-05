package BOJ;

import java.util.Scanner;

/*
 * 2022.05.05 daily algo/commit
 * Math
 * 효율성과 시간복잡도를 잘 따져보자.
 */

public class boj_17427 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// int형은 범위가 안되서 long을 써줘야한다.!
		long sum = 0;
		for(int i=1; i<=n; i++) {
			sum += (i*(n/i));
		}
		
		
		/*
		 * 시간 복잡도가 10초~ 3시간 나오기 때문에 모든 수를 다 구해볼 순 없다.
		int sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=Math.sqrt(i); j++) {
				if(i % j == 0) { // 약수일 때
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
