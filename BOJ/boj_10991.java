package BOJ;

import java.util.Scanner;

/*
 * 2021.06.03 daily algo/commit
 */

public class boj_10991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			star(i, N);
		}
		
		sc.close();
	}
	
	static void star(int line, int N) {
		for(int i=0; i<N-line; i++) {
			System.out.print(" ");
		}
		for(int i=1; i<=line*2-1; i++) {
			if(i%2 == 1) {
				System.out.print("*");
			}
			else {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
