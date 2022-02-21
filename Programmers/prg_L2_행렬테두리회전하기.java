package Programmers;

import java.util.Arrays;

/*
 * 2022.02.21 daily algo/commit
 * 
 */

public class prg_L2_행렬테두리회전하기 {
	
//	static int rows = 6;
//	static int columns = 6;
//	static int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
	static int rows = 3;
	static int columns = 3;
	static int[][] queries = {{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
//	static int rows = 100;
//	static int columns = 97;
//	static int[][] queries = {{1,1,100,97}};
	static int[] dxdy = {1, -1};
	static int[][] map, map_copy;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		map = new int[rows+1][columns+1];
		map_copy = new int[rows+1][columns+1];
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				map[i][j] = map_copy[i][j] = (i-1) * columns + j;
			}
		}
		int[] answer = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			answer[i] = rotation(queries[i]);
		}
        return answer;
    }
	
	public static int rotation(int[] points) {
		int x, y, min = Integer.MAX_VALUE;
		// →
		x = points[0];
		y = points[1];
		for(int k=0; k<points[3] - points[1]; k++) {
			map_copy[x][y+1] = map[x][y];
			min = Math.min(min, map[x][y]);
			y += dxdy[0];
		}
		// ↓
		x = points[0];
		y = points[3];
		for(int k=0; k<points[2] - points[0]; k++) {
			map_copy[x+1][y] = map[x][y];
			min = Math.min(min, map[x][y]);
			x += dxdy[0];
		}
		
		// ←
		x = points[2];
		y = points[3];
		for(int k=0; k<points[3] - points[1]; k++) {
			map_copy[x][y-1] = map[x][y];
			min = Math.min(min, map[x][y]);
			y += dxdy[1];
		}
		
		// ↑
		x = points[2];
		y = points[1];
		for(int k=0; k<points[2] - points[0]; k++) {
			map_copy[x-1][y] = map[x][y];
			min = Math.min(min, map[x][y]);
			x += dxdy[1];
		}
		
		// 깊은복사
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				map[i][j] = map_copy[i][j];
			}
		}
		
		return min;
	}

}
