package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.07.04 daily algorithm
 * 
 * BFS - 최단시간 구하기
 * 큐 2개를 사용하여 현재시간 큐, 다음시간 큐로 설정하여 현재시간 큐가 비면 
 * 현재시간 큐 = 다음시간 큐 로 변환하여 다시 다음시간 큐로 진행한다.
 * 
 * 최단 시간을 구해야하기 때문에 큐에서 나올 때 방문처리를 해준다. 
 */

public class boj_13549 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		bfs(n, k);
		System.out.println(time);
	}

	static boolean[] visited = new boolean[100001];
	static int time = 0;
	public static void bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> next_queue = new LinkedList<>();
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			visited[p] = true;
			if(p == k) break;
			
			if(p*2 <= 100000 && !visited[p*2]) {
				queue.add(p*2);
			}
			if(p-1 >= 0 && !visited[p-1]) next_queue.add(p-1);
			if(p+1 <= 100000 && !visited[p+1]) next_queue.add(p+1);
			
			if(queue.isEmpty()) {
				queue = next_queue;
				next_queue = new LinkedList<Integer>();
				time += 1;
			}
		}
	}
	
}
