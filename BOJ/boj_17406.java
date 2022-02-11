package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.12.27 daily algo/commit
 * 
 * Brute Force
 * 깊은배열 복사를 이용하여 변경 전 배열을 보존하고 바뀐 배열을 저장한다.
 * 규칙을 이용하여 배열을 바꾼다.
 */

public class boj_17406 {
	
	static int N, M, min = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] array, array_move;
	static Rotation[] rotation;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		
		array = new int[N+1][M+1];
		array_move = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				array[i][j] = array_move[i][j] = sc.nextInt();
			}
		}
		
		rotation = new Rotation[K];
		for(int i=0; i<K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			rotation[i] = new Rotation(r, c, s);
		}
		sc.close();
		
		int[] arr = new int[K];
		boolean[] visited = new boolean[K];
		permutation(K, K, arr, visited);
		System.out.println(min);
	}
	
	public static void permutation(int r, int n, int[] arr, boolean[] visited) {
		if(r == 0) {
//			System.out.println(Arrays.toString(arr));
			// 초기화
			for(int i=0; i<array.length; i++) {
				System.arraycopy(array[i], 0, array_move[i], 0, array_move[i].length);
			}
			
			int[][] array_move_copy = new int[N+1][M+1];
			for(int i=0; i<array_move.length; i++) {
				System.arraycopy(array_move[i], 0, array_move_copy[i], 0, array_move_copy[i].length);
			}
			calculation(arr, array_move, array_move_copy);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[n-r] = i;
				permutation(r-1, n, arr, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void calculation(int[] arr, int[][] array_move, int[][] array_move_copy) {
		for(int k=0; k<arr.length; k++) {
			int r = rotation[arr[k]].r;
			int c = rotation[arr[k]].c;
			int s = rotation[arr[k]].s;
			System.out.println(r+" "+c+" "+s);
			for(int i=s; i>=1; i--) {
				// 한 변마다 s의 2배만큼 이동
				for(int j=0; j<i*2; j++) {
					// 사각형 네 변 이동
					array_move[r-i][c-i+j+1] = array_move_copy[r-i][c-i+j]; // 위
					array_move[r-i+j+1][c+i] = array_move_copy[r-i+j][c+i]; // 오
					array_move[r+i][c+i-j-1] = array_move_copy[r+i][c+i-j]; // 아래
					array_move[r+i-j-1][c-i] = array_move_copy[r+i-j][c-i]; // 왼
				}
			}
			// 깊은복사
			for(int i=0; i<array_move.length; i++) {
				System.arraycopy(array_move[i], 0, array_move_copy[i], 0, array_move_copy[i].length);
			}
		}
		
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=M; j++) {
				sum += array_move[i][j];
			}
			min = Math.min(sum, min);
		}
	}
}

class Rotation {
	int r, c, s;
	Rotation(int r, int c, int s){
		this.r = r;
		this.c = c;
		this.s = s;
	}
}