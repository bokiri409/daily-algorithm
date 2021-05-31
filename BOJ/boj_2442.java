package BOJ;

import java.util.Scanner;

/*
 * 2021.05.31 daily algo/commit
 */

public class boj_2442 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int starLine = sc.nextInt(); // input ��
		
		for(int i=1; i<=starLine; i++) {
			star(starLine, i); // ���پ� ���
		}
		
		sc.close();
	}
	
	static void star(int starLine, int n) {
		for(int i=0; i<starLine-n; i++) { // ��ĭ ���
			System.out.print(" ");
		}
		for(int i=1; i<=2*n-1; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

}
