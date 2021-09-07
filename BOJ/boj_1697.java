package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2021.09.07 daily algo/commit
 * 
 * 최단거리 - BFS
 * time으로 시간체크 (현재 current의 time보다 +1만큼 계산해서 큐에 넣기)
 * 수빈이 위치가 동생위치가 크다면 -1이 제일 빠른 길이므로 N-K가 최단거리이다.
 */

public class boj_1697 {
	
	static int[] move = {-1,1,2};
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치
		
		int answer = 0;
		if(N >= K) {
			answer = N - K;
		}
		if(N < K) {
			answer = bfs(N, K);
		}
		
		System.out.println(answer);
		br.close();
	}
	
	private static int bfs(int n, int k) {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(n, 0));
		int current = 0;
		int time = 0;
		
		loop:
		while(!q.isEmpty()) {
			current = q.peek().current;
			time = q.poll().time;
			
			visited[current] = true;
			for(int i=0; i<3; i++) {
				int cal = 0;
				if(i == 2) {
					cal = current*move[i];
					if(cal == k) break loop;
				}
				else {
					cal = current + move[i];
					if(cal < 0) continue;
					if(cal == k) break loop;
				}
				if(cal <= 100000 && !visited[cal]) {
					q.offer(new Info(cal, time+1));
					visited[cal] = true;
				}
			}
		}
		return time+1;
	}
	
	static class Info {
		int current;
		int time;
		
		public Info(int current, int time) {
			this.current = current;
			this.time = time;
		}
	}

}
