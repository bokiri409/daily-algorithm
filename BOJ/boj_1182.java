package BOJ;

import java.util.Scanner;

/*
 * 2022.06.20 daily algorithm
 * 
 * 비트마스크로 풀이 
 * N : 1~20 => 0~19로 변경해서 풀이
 * 0일때는 공집합이므로 1~19만 검사한다.
 * N => 1111...11 (N개) : 1 << N = 1 * 2^N가지 경
 */

public class boj_1182 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] set = new int[N];
		for(int i=0; i<N; i++) {
			set[i] = sc.nextInt();
		}
		sc.close();
		
		int cnt = 0;
		// 1 ~ 2^N까지 만들 수 있는 부분수열 모두 검사 
		for(int i=1; i<(1 << N); i++) { 
			int sum = 0;
			// j번째 원소 유무 확인 
			for(int j=0; j<N; j++) { 
				if((i & (1 << j)) != 0) { // 존재하면 
					sum += set[j];
				}
			}
			
			if(sum == S) cnt += 1;
		}
		
		System.out.println(cnt);
	}

}
