package BOJ;

import java.util.Scanner;

/*
 * 2021.06.03 daily algo/commit
 */

public class boj_2446 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=2*N-1; i++) {
			star(i, N);
		}
		
		sc.close();
	}
	
	static void star(int line, int N) {
		if(line>N) {
			line = N - (line-N);
		}
		for(int i=1; i<line; i++) {
			System.out.print(" "); 
		}
		for(int i=0; i<2*(N-line+1)-1; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

}
