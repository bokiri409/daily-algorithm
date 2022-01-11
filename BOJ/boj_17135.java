package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.01.11 daily algo/commit
 * 
 * Brute Force
 * 총 3명의 궁수를 기준으로 거리1부터 d까지 왼쪽에서부터 공격할 수 있는 적을 찾는다.
 * 중복이 허용되는 것을 주의하면서 코드를 짜야한다.
 */

public class boj_17135 {

	static int n, m, d, max = 0;
	static int[] archer = new int[3]; // 궁수 위치
	static int[][] grid;
	static int number = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt(); // 궁수 공격 제한거리
		grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		sc.close();

		archer(m, 3, 0);
		System.out.println(max);
	}

	// 궁수 배치
	public static void archer(int nn, int r, int start) {
		if (r == 0) {
			int[][] grid_copy = new int[n][m];
			for (int i = 0; i < n; i++) {
				System.arraycopy(grid[i], 0, grid_copy[i], 0, m);
			}
			max = Math.max(max, attack(archer, grid_copy));
			return;
		}
		for (int i = start; i < nn; i++) {
			archer[3 - r] = i;
			archer(nn, r - 1, i + 1);
		}
	}

	// 적 공격
	public static int attack(int[] archer, int[][] grid_copy) {
		int num = 0; // 공격 횟수
		boolean[] archer_v = new boolean[3];
		// 가장 왼쪽 적부터 공격, 궁수 기준
		for(int k=0; k<3; k++) { // 궁수
			if (!archer_v[k]) {
				loop: 
				for(int i=1; i<=d; i++) {
					for(int j=-i+1; j<=i-1; j++) {
						int x = -(i - Math.abs(j));
						if (n + x >= 0 && n + x < n && archer[k] + j >= 0 && archer[k] + j < m) {
							if (grid_copy[n + x][archer[k] + j] == 1) {
								grid_copy[n + x][archer[k] + j] = -1; // 적 소멸
								num += 1;
								break loop;
							}
							else if (grid_copy[n + x][archer[k] + j] == -1) { // 중복 공격
								break loop;
							}
						}
					}
				}
			}
			if (k == 2) {
				if (move(grid_copy) == 0)
					break; // 적이 없을 때 스톱
				k = -1; // 다시 처음부터
				Arrays.fill(archer_v, false);
			}
		}

		/* 격자판 중심으로 풀이 (실패코드)
      loop: 
      for (int i=0; i<m-1; i++) {
         for (int j=n-1; j>=0; j--) {
            if (grid_copy[j][i] == 1) {
               for (int k=0; k<3; k++) {
                  if (!archer_v[k]) {
                     if (Math.abs(j - n) + Math.abs(i - archer[k]) <= d) {
//                        if(grid_copy[j][i] == 1) num += 1;
                        grid_copy[j][i] = 0; // 적 소멸
                        archer_v[k] = true;
                        num += 1;
                        break;
                     }
                  }
               }
//               num += 1;
            }
            if ((j == 0 && i == m - 1) || (archer_v[0] && archer_v[1] && archer_v[2])) {
               if (move(grid_copy) == 0) {
                  break loop; // 적이 없을 때 스톱
               }
               i = n - 1;
               j = -1; // 다시 처음부터
               Arrays.fill(archer_v, false);
            }
         }
      }
		*/
		return num;
	}

	// 턴 종료 후 적 이동
	public static int move(int[][] grid_copy) {
		int enemy = 0;
		Arrays.fill(grid_copy[n - 1], 0); // 마지막 행 0으로 채우기
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if(grid_copy[i][j] == -1) grid_copy[i][j] = 0;
				if(grid_copy[i][j] == 1) {
					grid_copy[i][j] = 0;
					grid_copy[i + 1][j] = 1; // 적 아래로 이동
					enemy += 1;
				}
			}
		}
		return enemy;
	}
}