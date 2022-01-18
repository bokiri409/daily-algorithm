package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.01.18 daily algo/commit
 * 
 * Brute Force
 * 문제에 대한 기본적인 이해!
 * - 한 이닝은 3아웃이 되기 전까지 반복된다.
 * - 3아웃 시 주자는 초기화된다.
 * - 다음 이닝으로 넘어갈 때 타자의 순서는 유지된다.
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
		
		runners = new int[10]; // 현재 타자 순서
		runners[4] = 1; // 4번타자는 무조건 1번선수
		order(9, 1, 2, runners);
		
		/* 타자 순서를 고려하지 않은 플레이 - 오류코드
		for(int i=0; i<n; i++) {
			if(out >= 3) break;
			while(true) {
				if(idx >= 9) idx = 0;
				// 유효타일 때
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
				// 아웃일 때
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
	
	// 선수 순서 정하기
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
		int idx = 1; // 순서
		int[] base = new int[4]; // 현재 베이스에 있는 선수
		base[0] = 1;
		int out = 0; // 아웃 수
		int score = 0; // 현재 점수
		
		for(int i=0; i<n; i++) {
			while(true) {
				if(idx > 9) idx = 1;
				// 유효타일 때
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
				// 아웃일 때
				else {
					idx += 1;
					out += 1;
					if(out >= 3) {
						out = 0; // 아웃 횟수 초기화
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
