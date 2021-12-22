package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.12.22 daily algo/commit
 * 
 * Brute Force
 * 3중포문으로 조합을 사용하지 않고 바로 구할 수 있다.
 */

public class boj_2422_2 {
	
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] noMix = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 맛없는 아이스크림 조합
			if(a < b) noMix[a][b] = true;
			else noMix[b][a] = true;
		}
		
		for(int i=1; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				// 맛없는 조합이 아닐때만 검사
				if(noMix[i][j] == false) {
					for(int k=j+1; k<=N; k++) {
						if(noMix[i][k] == false && noMix[j][k] == false) cnt += 1;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
