package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2021.08.20 daily algo/commit
 * 
 * BFS/DFS
 * 인접행렬로 할 시 메모리초과
 * 인접리스트로 풀이
 * 
 * 
 * 참고 : https://zoosso.tistory.com/395
 * 
 */

public class boj_11725 {
	
	static int N; // 정점의 개수
	static boolean[] visited;
	static int[] parent;
//	static int[][] adjMatrix;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
//		adjMatrix = new int[N+1][N+1];
		tree.add(new ArrayList<Integer>()); // 0에 임시값 넣어주기
		for(int i=0; i<N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		visited = new boolean[N+1];
		parent = new int[N+1];
		for(int i=0; i<N-1; i++) { 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			adjMatrix[from][to] = adjMatrix[to][from] = 1;
			tree.get(from).add(to);
			tree.get(to).add(from);
		}
		bfs();
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
		br.close();
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
//		boolean visited[] = new boolean[N+1];
		
		int current = 1;
		q.offer(current);
		visited[current] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
//			System.out.println(current);
//			for(int i=1; i<=N; i++) {
//				if(tree.get(current).get(i) == 1 && !visited[i]) {
//					q.offer(i);
//					parent[i] = current;
//					visited[i] = true; // 방법2 : 들어갈 때 방문처리
//				}
//			}
			for(int node : tree.get(current)) {
//				System.out.println("#"+node);
				if(!visited[node]) {
					q.offer(node);
					parent[node] = current;
					visited[node] = true;
				}
			}
		}
		
	}

}
