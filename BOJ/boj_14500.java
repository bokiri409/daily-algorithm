package BOJ;

import java.util.Scanner;

/*
 * 2022.05.16 daily algo/commit
 * 
 * Brute Force 
 * 각 기준점에서 모든 가능한 테트리미노 경우를 해보고 가장 큰 합을 구한다.
 * 테트리미노 제대로 안쓰면 잔오류가 많으니 주의할 것
 */

public class boj_14500 {
						  // 1번
	static int[][][] tetromino = {{{0, 1}, {0, 2}, {0, 3}},
								  {{1, 0}, {2, 0}, {3, 0}},
						  // 2번
						  {{0, 1}, {1, 0}, {1, 1}},
						  // 3번
						  {{1, 0}, {2, 0}, {2, 1}},
						  {{1, 0}, {0, 1}, {0, 2}},
						  {{0, 1}, {1, 1}, {2, 1}},
						  {{0, 1}, {0, 2}, {-1, 2}},
						  {{1, 0}, {2, 0}, {2, -1}},
						  {{0, 1}, {0, 2}, {1, 2}},
						  {{0, 1}, {1, 0}, {2, 0}},
						  {{1, 0}, {1, 1}, {1, 2}},
						  // 4번
						  {{1, 0}, {1, 1}, {2, 1}},
						  {{0, 1}, {-1, 1}, {-1, 2}},
						  {{1, 0}, {1, -1}, {2, -1}},
						  {{0, 1}, {1, 1}, {1, 2}},
						  // 5번
						  {{0, 1}, {0, 2}, {1, 1}}, 
						  {{0, 1}, {-1, 1}, {0, 2}},
						  {{1, 0}, {1, -1}, {2, 0}},
						  {{1, 0}, {1, 1}, {2, 0}}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				max = Math.max(max, check(i, j, map, N, M));
			}
		}
		System.out.println(max);
	}
	
	public static int check(int x, int y, int[][] map, int n, int m) {
		int max = 0;
		for(int i=0; i<tetromino.length; i++) {
			int sum = map[x][y];
			for(int j=0; j<tetromino[i].length; j++) {
				if(x+tetromino[i][j][0] < 0 || x+tetromino[i][j][0] >= n || y+tetromino[i][j][1] < 0 || y+tetromino[i][j][1] >= m) {
					sum = 0;
					break;
				}
				sum += map[x+tetromino[i][j][0]][y+tetromino[i][j][1]];
			}
			System.out.println(i+" : "+sum+", "+x+", "+y);
			max = Math.max(max, sum);
		}
		return max;
	}
}
