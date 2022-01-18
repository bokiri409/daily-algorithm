package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.01.18 daily algo/commit
 * 
 * Brute Force
 * ������ ���� �⺻���� ����!
 * - �� �̴��� 3�ƿ��� �Ǳ� ������ �ݺ��ȴ�.
 * - 3�ƿ� �� ���ڴ� �ʱ�ȭ�ȴ�.
 * - ���� �̴����� �Ѿ �� Ÿ���� ������ �����ȴ�.
 */

public class boj_17281 {
	
	static int n, max = 0;
	static int[][] inning;
	static int[] runners;
	static boolean[] visited = new boolean[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		inning = new int[n][9];
		for(int i=0; i<n; i++) {
			for(int j=0; j<9; j++) {
				inning[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		runners = new int[10]; // ���� Ÿ�� ����
		runners[4] = 1; // 4��Ÿ�ڴ� ������ 1������
		order(9, 1, 2, runners);
		
		/* Ÿ�� ������ ������� ���� �÷��� - �����ڵ�
		for(int i=0; i<n; i++) {
			if(out >= 3) break;
			while(true) {
				if(idx >= 9) idx = 0;
				// ��ȿŸ�� ��
				if(inning[i][idx] != 0) {
					for(int k=3; k>=1; k--) {
						if(base[k] > 0) {
							base[k] = 0;
							if(k + inning[i][idx] > 3) score += 1;
							else {
								base[k+inning[i][idx]] = 1;
							}
						}
					}
					if(inning[i][idx] == 4) score += 1;
					else base[inning[i][idx]] = 1;
					idx += 1;
				}
				// �ƿ��� ��
				else {
					idx += 1;
					out += 1;
					break;
				}
			}
		}
		*/
		System.out.println(max);
	}
	
	// ���� ���� ���ϱ�
	public static void order(int n, int r, int start, int[] runners) {
		if(r == 9) {
			max = Math.max(max, play(runners));
			return;
		}
		for(int i=2; i<=9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(r >= 4) {
					runners[r+1] = i;
				}
				else runners[r] = i;
				order(n, r+1, i+1, runners);
				visited[i] = false;
			}
		}
	}

	public static int play(int[] runners) {
		int idx = 1; // ����
		int[] base = new int[4]; // ���� ���̽��� �ִ� ����
		base[0] = 1;
		int out = 0; // �ƿ� ��
		int score = 0; // ���� ����
		
		for(int i=0; i<n; i++) {
			while(true) {
				if(idx > 9) idx = 1;
				// ��ȿŸ�� ��
				if(inning[i][runners[idx]-1] != 0) {
					int hits = inning[i][runners[idx]-1];
					for(int k=3; k>=0; k--) {
						if(k + hits > 3) {
							score += base[k];
						}
						else base[k + hits] = base[k];
						if(k == 0) base[k] = 1;
						else base[k] = 0;
					}
					idx += 1;
				}
				// �ƿ��� ��
				else {
					idx += 1;
					out += 1;
					if(out >= 3) {
						out = 0; // �ƿ� Ƚ�� �ʱ�ȭ
						Arrays.fill(base, 0);
						base[0] = 1;
						break;
					}
				}
			}
		}
		return score;
	}
}
