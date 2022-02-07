package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.02.07 daily algo/commit
 */

public class boj_1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] time = new int[N][2];
		for(int i=0; i<N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(time, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int start = time[0][1];
		int cnt = 1;
		for(int i=1; i<N; i++) {
			if(start <= time[i][0]) {
				cnt += 1;
				start = time[i][1];
			}
		}
		System.out.println(cnt);
	}

}
