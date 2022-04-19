package Programmers;

/*
 * 2022.04.19 daily algo/commit
 * 
 * BFS로 풀면 효율성 테스트에서 걸리므로 DP를 이용한다.
 * 해당 dp값은 위, 왼쪽 옆, 대각선 왼쪽 옆 세군데를 검사하여 가능한 정사각형 변의 최대값을 적는다.
 * 참고 : https://simyeju.tistory.com/50
 */

public class prg_L2_가장큰정사각형 {
	
//	static int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//	static int[][] board = {{0,1,1,1,1,0,0},{1,1,1,1,1,0,1},{1,1,1,1,1,1,1},{0,0,1,0,1,1,1},{0,1,1,0,1,0,1},{0,1,1,0,1,0,1}};
	static int[][] board = {{1,1},{1,1}};
	static int[] dx = {-1, -1, 0};
	static int[] dy = {0, -1, -1};

	public static void main(String[] args) {
		System.out.println(solution(board));
	}

	public static int solution(int [][]board) {
		int max = 0;
		int[][] dp = new int[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			dp[i][0] = board[i][0];
			max = Math.max(max, dp[i][0]);
		}
		for(int i=0; i<board[0].length; i++) {
			dp[0][i] = board[0][i];
			max = Math.max(max, dp[0][i]);
		}
		
		for(int i=1; i<board.length; i++) {
			for(int j=1; j<board[0].length; j++) {
				int side = Integer.MAX_VALUE;
				boolean flag = false;
				for(int k=0; k<3; k++) {
					if(board[i][j] == 0) {
						dp[i][j] = 0;
						flag = true;
						break;
					}
					if(i+dx[k] < board.length && i+dx[k] >= 0 && j+dy[k] < board[0].length && j+dy[k] >= 0) {
						if(dp[i+dx[k]][j+dy[k]] == 0) {
							dp[i][j] = board[i][j];
							flag = true;
							break;
						}
						else {
							side = Math.min(side,dp[i+dx[k]][j+dy[k]]);
						}
					}
				}
				if(!flag) {
					dp[i][j] = side+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		return max*max;
    }
	
}
