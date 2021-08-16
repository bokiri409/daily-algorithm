package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2021.08.16 daily algo/commit
 * 
 * BFS/DFS
 * 
 */

public class boj_1260 {
	
	static int N; // 정점 수
	static int M; // 간선 수
	static int V; // 시작 정점 번호
	
	static boolean[] visited;
	static int[][] adjMatrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
		sc.close();
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(int i=1; i<=N; i++) {
			if(adjMatrix[current][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int current) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		
		q.offer(current);
		visited[current] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			System.out.print(current+" ");
			for(int i=1; i<=N; i++) {
				if(adjMatrix[current][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true; // 방법2 : 들어갈 때 방문처리
				}
			}
		}
		
	}

}
