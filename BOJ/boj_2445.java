package BOJ;

import java.util.Scanner;

/*
 * 2021.06.01 daily algo/commit
 */

public class boj_2445 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ÀÔ·Â°ª
		
		for(int i=1; i<N*2; i++) {
			star(i, N);
		}
		
		sc.close();
	}
	
	static void star(int line, int N) {
		if(line>N) {
			line = N - (line-N);
		}
		for(int i=0; i<line; i++) {
			System.out.print("*");
		}
		for(int i=0; i<(N-line)*2; i++) {
			System.out.print(" ");
		}
		for(int i=0; i<line; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

}
