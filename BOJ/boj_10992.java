package BOJ;

import java.util.Scanner;

/*
 * 2021.06.08 daily algo/commit
 */

public class boj_10992 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			star(i, N);
		}
		
		sc.close();
	}
	
	static void star(int line, int n) {
		for(int i=0; i<n-line; i++) {
			System.out.print(" ");
		}
		if(line == 1) {
			System.out.print("*");
		}
		else if(line == n) {
			for(int i=0; i<line*2-1; i++) {
				System.out.print("*");
			}
		}
		else {
			System.out.print("*");
			for(int i=0; i<line*2-3; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
		}
		System.out.println();
	}

}
