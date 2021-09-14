package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.09.14 daily algo/commit
 * 
 * �ִܰŸ� - BFS, �÷��̵�-���� �˰���
 * ���ϰ��� �ϴ� �л��� ��� �л��� ����Ǿ� �־�� �Ѵ�.
 */

public class boj_2458 {
	
	static int[][] adjMatrix;
//	static int INF = Integer.MAX_VALUE;
	static int INF = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // �л� ��
		int M = Integer.parseInt(st.nextToken()); // Ű ���� Ƚ��
		adjMatrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				adjMatrix[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sta = Integer.parseInt(st.nextToken()); // �л� a�� b���� �۴�
			int stb = Integer.parseInt(st.nextToken());
			
			adjMatrix[sta][stb] = 1;
		}
		
		// �÷��̵� ���� 
		for(int k=1; k<=N; k++) { // ��� �Ѱ����� N������ ��� ���İ��� ���
			for(int i=1; i<=N; i++) { // ��� j���� k�� ���� ���
				if(i == k) continue;
				for(int j=1; j<=N; j++) {
					if(i == j || j == k) continue;
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]); // k�� ��ȸ�ϴ°� 
				}
			}
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(i == j)continue; // �ڱ� �ڽŰ��� �񱳴� ���� ����
				if(adjMatrix[i][j] < INF || adjMatrix[j][i] < INF) cnt+=1;
			}
			if(cnt == N-1) answer++;
		}
		System.out.println(answer);
		
		br.close();
	}

}
