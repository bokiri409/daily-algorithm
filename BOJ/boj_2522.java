package BOJ;

import java.util.Scanner;

/*
 * 2021.06.02 daily algo/commit
 */

public class boj_2522 {
	
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=1; i<N*2; i++) {
			star(i);
		}
		
		
		sc.close();
	}

	static void star(int line) {
		if(line>N) {
			line = N - (line-N);
		}
		for(int i=0; i<N-line; i++) {
			System.out.print(" ");
		}
		for(int i=0; i<line; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
