package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.09.01 daily algo/commit
 * 
 * BFS/DFS
 */

public class boj_2606 {
	
	static int N;
	static int M;
	static boolean[] visited;
	static int[][] networks;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 노드 수
		M = Integer.parseInt(br.readLine()); // 간선 수
		networks = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			networks[from][to] = networks[to][from] = 1;
		}
//		int cnt = 0; // 바이러스 걸린 컴퓨터 수
		dfs(1);
		System.out.println(cnt);
		
		br.close();
	}
	
	static void dfs(int current) {
		visited[current] = true;
		
		for(int i=1; i<=N; i++) {
			if(networks[current][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}

}
