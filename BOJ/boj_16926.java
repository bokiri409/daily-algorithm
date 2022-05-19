package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 2022.05.19 daily algo/commit
 * 
 * Simulation
 * 배열의 그룹을 나누어서 회전하는 순서를 정한다.
 */

public class boj_16926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int k = Math.min(N, M)/2;
		for(int i=0; i<k; i++) {
			List<Integer> arr = new ArrayList<Integer>();
			// 위
			for(int j=i; j<M-i-1; j++) {
				arr.add(map[i][j]);
			}
			// 오른
			for(int j=i; j<N-i-1; j++) {
				arr.add(map[j][M-i-1]);
			}
			// 아래
			for(int j=M-i-1; j>i; j--) {
				arr.add(map[N-i-1][j]);
			}
			// 왼
			for(int j=N-i-1; j>i; j--) {
				arr.add(map[j][i]);
			}
			
			// 회전
			int idx = R % arr.size();
			// 위
			for(int j=i; j<M-i-1; j++) {
				if(idx >= arr.size()) idx -= arr.size();
				map[i][j] = arr.get(idx);
				idx += 1;
			}
			// 오른
			for(int j=i; j<N-i-1; j++) {
				if(idx >= arr.size()) idx -= arr.size();
				map[j][M-i-1] = arr.get(idx);
				idx += 1;
			}
			// 아래
			for(int j=M-i-1; j>i; j--) {
				if(idx >= arr.size()) idx -= arr.size();
				map[N-i-1][j] = arr.get(idx);
				idx += 1;
			}
			// 왼
			for(int j=N-i-1; j>i; j--) {
				if(idx >= arr.size()) idx -= arr.size();
				map[j][i] = arr.get(idx);
				idx += 1;
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
