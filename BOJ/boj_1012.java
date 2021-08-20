package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1012 {
	
	static int N,M;
	static int[][] field;
	static boolean[] cabbage;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			field = new int[N][M];
			int K = Integer.parseInt(st.nextToken()); // 배추 수
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				field[to][from] = 1; // 배추 위치
			}
			
			System.out.println(checking()); // 지렁이 개수 체크
		}
		
		
		br.close();
	}
	
	private static int checking() {
		int cnt = 0; // 지렁이 수
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] == 1) { // 배추 일 때
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void dfs(int i, int j) {
		field[i][j] = 0;
		for(int k=0; k<4; k++) {
			if(i+dx[k] >= 0 && i+dx[k] < N && j+dy[k] >=0 && j+dy[k] < M) { // 사방에 배추 있는 지 검사
				if(field[i+dx[k]][j+dy[k]] == 1) { // 인접한 곳에 배추가 있으면
					dfs(i+dx[k], j+dy[k]);
				}
			}
		}
	}

}
