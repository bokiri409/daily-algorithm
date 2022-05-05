package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.05.05 daily algo/commit
 * Math
 */

public class boj_1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		System.out.println(max * min);
		
		/*
		int[] list = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		
		int N = list[0] * list[n-1];
		System.out.println(N);
		*/
	}

}
