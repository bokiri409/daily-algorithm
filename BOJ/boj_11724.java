package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.08.17 daily algo/commit
 * 
 * BFS/DFS
 */

public class boj_11724 {
	
	private static int[][] adjMatrix;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		adjMatrix = new int[N+1][N+1]; // 인접행렬
		visited = new boolean[N+1]; // 방문 체크
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i, N);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	private static void dfs(int current, int n) {
		visited[current] = true; // 방문체크
		
		for(int i=1; i<=n; i++) {
			if(adjMatrix[current][i] == 1 && !visited[i]) {
				dfs(i, n);
			}
		}
	}

}
