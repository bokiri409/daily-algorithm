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
			M = Integer.parseInt(st.nextToken()); // ���� ����
			N = Integer.parseInt(st.nextToken()); // ���� ����
			field = new int[N][M];
			int K = Integer.parseInt(st.nextToken()); // ���� ��
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				field[to][from] = 1; // ���� ��ġ
			}
			
			System.out.println(checking()); // ������ ���� üũ
		}
		
		
		br.close();
	}
	
	private static int checking() {
		int cnt = 0; // ������ ��
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] == 1) { // ���� �� ��
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
			if(i+dx[k] >= 0 && i+dx[k] < N && j+dy[k] >=0 && j+dy[k] < M) { // ��濡 ���� �ִ� �� �˻�
				if(field[i+dx[k]][j+dy[k]] == 1) { // ������ ���� ���߰� ������
					dfs(i+dx[k], j+dy[k]);
				}
			}
		}
	}

}
