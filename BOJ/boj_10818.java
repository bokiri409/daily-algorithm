package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.06.17 daily algo/commit
 */

public class boj_10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] list = new int[N];
		for(int n=0; n<N; n++) {
			list[n] = sc.nextInt();
		}
		
		Arrays.sort(list);
		int min = list[0];
		int max = list[N-1];
		
		System.out.print(min + " " + max);
		sc.close();
	}

}