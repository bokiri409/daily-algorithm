package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.01.11 daily algo/commit
 * 
 * Brute Force
 * �� 3���� �ü��� �������� �Ÿ�1���� d���� ���ʿ������� ������ �� �ִ� ���� ã�´�.
 * �ߺ��� ���Ǵ� ���� �����ϸ鼭 �ڵ带 ¥���Ѵ�.
 */

public class boj_17135 {

	static int n, m, d, max = 0;
	static int[] archer = new int[3]; // �ü� ��ġ
	static int[][] grid;
	static int number = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt(); // �ü� ���� ���ѰŸ�
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

	// �ü� ��ġ
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

	// �� ����
	public static int attack(int[] archer, int[][] grid_copy) {
		int num = 0; // ���� Ƚ��
		boolean[] archer_v = new boolean[3];
		// ���� ���� ������ ����, �ü� ����
		for(int k=0; k<3; k++) { // �ü�
			if (!archer_v[k]) {
				loop: 
				for(int i=1; i<=d; i++) {
					for(int j=-i+1; j<=i-1; j++) {
						int x = -(i - Math.abs(j));
						if (n + x >= 0 && n + x < n && archer[k] + j >= 0 && archer[k] + j < m) {
							if (grid_copy[n + x][archer[k] + j] == 1) {
								grid_copy[n + x][archer[k] + j] = -1; // �� �Ҹ�
								num += 1;
								break loop;
							}
							else if (grid_copy[n + x][archer[k] + j] == -1) { // �ߺ� ����
								break loop;
							}
						}
					}
				}
			}
			if (k == 2) {
				if (move(grid_copy) == 0)
					break; // ���� ���� �� ����
				k = -1; // �ٽ� ó������
				Arrays.fill(archer_v, false);
			}
		}

		/* ������ �߽����� Ǯ�� (�����ڵ�)
      loop: 
      for (int i=0; i<m-1; i++) {
         for (int j=n-1; j>=0; j--) {
            if (grid_copy[j][i] == 1) {
               for (int k=0; k<3; k++) {
                  if (!archer_v[k]) {
                     if (Math.abs(j - n) + Math.abs(i - archer[k]) <= d) {
//                        if(grid_copy[j][i] == 1) num += 1;
                        grid_copy[j][i] = 0; // �� �Ҹ�
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
                  break loop; // ���� ���� �� ����
               }
               i = n - 1;
               j = -1; // �ٽ� ó������
               Arrays.fill(archer_v, false);
            }
         }
      }
		*/
		return num;
	}

	// �� ���� �� �� �̵�
	public static int move(int[][] grid_copy) {
		int enemy = 0;
		Arrays.fill(grid_copy[n - 1], 0); // ������ �� 0���� ä���
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if(grid_copy[i][j] == -1) grid_copy[i][j] = 0;
				if(grid_copy[i][j] == 1) {
					grid_copy[i][j] = 0;
					grid_copy[i + 1][j] = 1; // �� �Ʒ��� �̵�
					enemy += 1;
				}
			}
		}
		return enemy;
	}
}