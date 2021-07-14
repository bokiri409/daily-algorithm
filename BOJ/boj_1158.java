package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2021.07.14 daily algo/commit
 * 
 * 1. 큐를 이용하여 K번째 도달하기 전까지 뒤로 붙이기
 * 2. 링크드 리스트를 이용
 */

public class boj_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		int N, K = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		while(!q.isEmpty()) { // 리스트 빌 때까지
			for(int i=0; i<K; i++) {
				if(i==K-1) { // K번째 일 때
					sb.append(q.poll()); // 제거된 번호
					if(!q.isEmpty()) { // 마지막이 아니라면 쉼표 추가
						sb.append(", ");
					}
				}
				else { // K번째 아닐 때 뒤로 붙이기
					q.add(q.poll());
				}
			}
		}
		sb.append(">");
		System.out.print(sb);
		br.close();
	}

}
