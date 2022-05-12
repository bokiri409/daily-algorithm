package BOJ;

import java.util.Scanner;

/*
 * 2022.05.12 daily algo/commit
 */

public class boj_1476 {
	
	static final int earth = 15;
	static final int sun = 28;
	static final int moon = 19;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt()-1;
		int S = sc.nextInt()-1;
		int M = sc.nextInt()-1;
		sc.close();
		
		for(int i=0; ; i++) {
			if(i%earth == E && i%sun == S && i%moon == M) {
				System.out.println(i+1);
				break;
			}
		}
		
		/*
		int n = -1; // 배수
		int year = 0; // 구하고자 하는 연도
		while(true) {
			n += 1;
			year = (n*earth)+(E % earth);
			if(year % sun == (S % sun)) {
				if(year % moon == (M % moon)) {
					if(year == 0) continue;
					break;
				}
			}
		}
		sc.close();
		System.out.println(year);
	    */
	}

}
