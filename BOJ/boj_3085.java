package BOJ;

import java.util.Scanner;

/*
 * 2022.05.11 daily algo/commit
 * 
 * Brute Force
 * 가능한 모든 경우 다 해보기
 * 
 * 선택한 사탕 기준으로 오른쪽, 아래쪽만 체크하면 모든 경우를 다 체크할 수 있다.
 * 사탕을 바꾼 부분만 검사 진행해도 최대값을 구할 수 있다.
 * 바꾸지 않은 부분의 줄에서 최대값이 나와도 이미 해당 줄에서 교환하면서 최대값을 구하기 때문에 상관없다!
 */

public class boj_3085 {
	
	static int[] dx = {0, 1};
	static int[] dy = {1, 0}; // 오, 아래

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] candy = new char[n][n];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			candy[i] = s.toCharArray();
		}
		
		int answer = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				char temp = candy[i][j];
				
				// 오른쪽 교환
				if(i+dx[0] >= 0 && i+dx[0] < n && j+dy[0] >= 0 && j+dy[0] < n) {
					candy[i][j] = candy[i+dx[0]][j+dy[0]];
					candy[i+dx[0]][j+dy[0]] = temp;
					answer = Math.max(answer, exchange(candy, i, i, j, j+1));
					// 교환 되돌리기
					candy[i+dx[0]][j+dy[0]] = candy[i][j];
					candy[i][j] = temp;
				}
				
				// 아래쪽 교환
				if(i+dx[1] >= 0 && i+dx[1] < n && j+dy[1] >= 0 && j+dy[1] < n) {
					candy[i][j] = candy[i+dx[1]][j+dy[1]];
					candy[i+dx[1]][j+dy[1]] = temp;
					answer = Math.max(answer, exchange(candy, i, i+1, j, j));
					// 교환 되돌리기
					candy[i+dx[1]][j+dy[1]] = candy[i][j];
					candy[i][j] = temp;
				}
			}
		}
		System.out.println(answer);
	}
	
	// 검사할 열과 행. (변경이 일어난 열 또는 행만 검사하면 됨)
	public static int exchange(char[][] candy, int start_i, int end_i, int start_j, int end_j) {
		int max = 1; // 연속되는 가장 긴 수
		
		/*
		// 모든 행과 열을 다시 검사 => 중복되는 것이 많다.
		// 행
		for(int i=0; i<candy.length; i++) {
			int cnt = 1;
			for(int j=1; j<candy.length; j++) {
				if(candy[i][j-1] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		
		// 검사할 열
		for(int j=0; j<candy.length; j++) {
			int cnt = 1;
			for(int i=1; i<candy.length; i++) {
				if(candy[i-1][j] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		*/
		
		// 바뀐 부분만 검사 진행 
		// 바꾸지 않은 부분에서 최대값이 나와도 이미 그 부분에서 교환하면서 최대값을 세기때문에 굳이 모든 경우를 매번 다 검사하지 않아도 된다.!
		// 검사할 행
		for(int i=start_i; i<=end_i; i++) {
			int cnt = 1;
			for(int j=1; j<candy.length; j++) {
				if(candy[i][j-1] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		
		// 검사할 열
		for(int j=start_j; j<=end_j; j++) {
			int cnt = 1;
			for(int i=1; i<candy.length; i++) {
				if(candy[i-1][j] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		
		return max; 
	}

}
