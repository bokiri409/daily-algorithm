package Programmers;

/*
 * 2021.08.16 daily algo/commit
 * 
 * BFS/DFS
 */

public class prg_network {
	
	private static boolean[] visited;

	public static void main(String[] args) {
		int[][] one = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] two = {{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(3, one));
		System.out.println(solution(3, two));
	}
	
	private static int solution(int n, int[][] computers) {
		visited = new boolean[n];
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(!visited[i]) { // 방문하지 않은 정점만
				cnt++;
				dfs(i, n);
			}
		}
        int answer = cnt;
        return answer;
    }
	
	static int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
	private static void dfs(int current, int n) {
		visited[current] = true;
		
		for(int i=0; i<n; ++i) {
			if(current != i) {
				if(computers[current][i] == 1 && !visited[i]) {
					dfs(i, n);
				}
			}
		}
	}

}
