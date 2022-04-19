package Programmers;

/*
 * 2022.04.19 daily algo/commit
 * 
 * BFS�� Ǯ�� ȿ���� �׽�Ʈ���� �ɸ��Ƿ� DP�� �̿��Ѵ�.
 * �ش� dp���� ��, ���� ��, �밢�� ���� �� �������� �˻��Ͽ� ������ ���簢�� ���� �ִ밪�� ���´�.
 * ���� : https://simyeju.tistory.com/50
 */

public class prg_L2_����ū���簢�� {
	
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
