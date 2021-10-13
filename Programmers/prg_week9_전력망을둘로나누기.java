package Programmers;

/*
 * 2021.10.13 daily algo/commit
 * 
 * 프로그래머스 위클리9 - DFS
 */

public class prg_week9_전력망을둘로나누기 {
	
//	static int n = 9;
	static int n = 7;
//	static int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
	static int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
	
	static int[][] matrix;
	static boolean[] visited;
	static int num = 0;

	public static void main(String[] args) {
		System.out.println(solution(n, wires));
	}
	
	public static int solution(int n, int[][] wires) {
        matrix = new int[n+1][n+1];
        
        for(int i=0; i<n-1; i++) {
        	matrix[wires[i][0]][wires[i][1]] = matrix[wires[i][1]][wires[i][0]] = 1;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++) { // 연결된 선 하나씩 끊는 경우
        	matrix[wires[i][0]][wires[i][1]] = matrix[wires[i][1]][wires[i][0]] = 0;
        	visited = new boolean[n+1];
        	num = 0;
        	dfs(1, n); // 송전탑 1번부터 확인
        	int v1 = num;
        	int v2 = n - v1;
        	if(min > Math.abs(v1-v2)) {
        		min = Math.abs(v1-v2); // 차이값
        	}
        	matrix[wires[i][0]][wires[i][1]] = matrix[wires[i][1]][wires[i][0]] = 1;
        }
        return min;
    }
	
	public static void dfs(int current, int n) {
		visited[current] = true;
		num += 1;
		for(int i=1; i<=n; i++) {
			if(matrix[current][i] == 1 && !visited[i]) {
				dfs(i, n);
			}
		}
	}

}
