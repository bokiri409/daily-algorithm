package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.07.05 daily algorithm
 * 
 * BFS + DP
 * dp[n-1] = dp[n+1] = dp[n*2] = n
 * 가장 빠른 시간을 찾는 것이기 때문에 k부터 역순으로 dp를 타고 n까지 출력하면 된다. 
 */

public class boj_13913 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		System.out.println(searching(n, k));
		StringBuilder sb = new StringBuilder();
		int next = k;
		while(true) {
			sb.insert(0, next + " ");
			next = dp[next];
			if(next == -1) break;
		}
		System.out.println(sb);
	}

	static boolean[] visited = new boolean[100001];
	static int[] dp = new int[100001];
	public static int searching(int n, int k) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(n, 0));
		dp[n] = -1;
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			if(point.p == k) return point.t;
			
			if(point.p-1 >= 0 && !visited[point.p-1]) {
				dp[point.p-1] = point.p;
				if(point.p-1 == k) return point.t+1;
				queue.add(new Point(point.p-1, point.t+1));
				visited[point.p-1] = true;
			}
			if(point.p+1 <= 100000 && !visited[point.p+1]) {
				dp[point.p+1] = point.p;
				if(point.p+1 == k) return point.t+1;
				queue.add(new Point(point.p+1, point.t+1));
				visited[point.p+1] = true;
			}
			if(point.p*2 <= 100000 && !visited[point.p*2]) {
				dp[point.p*2] = point.p;
				if(point.p*2 == k) return point.t+1;
				queue.add(new Point(point.p*2, point.t+1));
				visited[point.p*2] = true;
			}
		}
		return 0;
	}
	
	static class Point {
		int p, t;
		Point(int p, int t) {
			this.p = p;
			this.t = t;
		}
	}
}
