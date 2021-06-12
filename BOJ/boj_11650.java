package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2021.06.12 daily algo/commit
 * 
 * Comparator를 이용한 2차원 배열 정렬
 * 참고 : https://hooongs.tistory.com/63
 */

public class boj_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순
		Arrays.sort(list, (t1, t2) -> {
			if(t1[0] == t2[0]) {
				return Integer.compare(t1[1], t2[1]);
			}else {
				return Integer.compare(t1[0], t2[0]);
			}
		});
		
		for(int i=0; i<N; i++) {
			sb.append(list[i][0]).append(" ").append(list[i][1]).append(" ").append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
