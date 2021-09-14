package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.09.14 daily algo/commit
 * 
 * 최단거리 - BFS, 플로이드-워셜 알고리즘
 * 비교하고자 하는 학생이 모든 학생과 연결되어 있어야 한다.
 */

public class boj_2458 {
	
	static int[][] adjMatrix;
//	static int INF = Integer.MAX_VALUE;
	static int INF = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 키 비교한 횟수
		adjMatrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				adjMatrix[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sta = Integer.parseInt(st.nextToken()); // 학생 a가 b보다 작다
			int stb = Integer.parseInt(st.nextToken());
			
			adjMatrix[sta][stb] = 1;
		}
		
		// 플로이드 워셜 
		for(int k=1; k<=N; k++) { // 노드 한개부터 N개까지 모두 거쳐가는 경우
			for(int i=1; i<=N; i++) { // 노드 j에서 k로 가는 경우
				if(i == k) continue;
				for(int j=1; j<=N; j++) {
					if(i == j || j == k) continue;
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]); // k를 우회하는게 
				}
			}
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(i == j)continue; // 자기 자신과의 비교는 하지 않음
				if(adjMatrix[i][j] < INF || adjMatrix[j][i] < INF) cnt+=1;
			}
			if(cnt == N-1) answer++;
		}
		System.out.println(answer);
		
		br.close();
	}

}
