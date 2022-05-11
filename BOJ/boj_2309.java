package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.05.11 daily algo/commit
 * 
 * Brute Force
 * 가능한 모든 경우 다 해보기
 * 
 * 시간제한 2초
 * 9C7 == 9C2 : 36가지
 * 
 */

public class boj_2309 {
	
	static final int num = 9;
	static final int height = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int[] dwarfs = new int[num];
		for(int i=0; i<num; i++) {
			dwarfs[i] = sc.nextInt();
			sum += dwarfs[i]; // 총합
		}
		
		loop:
		for(int i=0; i<num-1; i++) {
			for(int j=i+1; j<num; j++) {
				if(sum - dwarfs[i] - dwarfs[j] == height) {
					dwarfs[i] = dwarfs[j] = -1;
					break loop;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Arrays.sort(dwarfs);
		for(int i=2; i<num; i++) {
			sb.append(dwarfs[i] + "\n");
		}
		System.out.println(sb.toString());
	}

}
