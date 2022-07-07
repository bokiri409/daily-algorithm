package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2022.07.07 daily algorithm
 * 
 * 
 * BFS - 가능한 경우의 수를 전부 살펴본 뒤 가장 빠른 시간 순으로 탐색한다. 
 * 메모리 초과 방지를 위하여 행은 현재 이모티콘 수, 열은 클립보드에 저장된 이모티콘 수를 방문배열로 체크하고 중본되는 검사를 줄인다.
 * 이모티콘 개수 n
 * 복사 : n *= 2
 * 붙여넣기 : n * 2
 * 삭제 : n - 1
 */

public class boj_14226 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		sc.close();
		
		System.out.println(copy(1, s));
	}

	static boolean[][] visited = new boolean[1001][1001];
	public static int copy(int n, int s) {
		Queue<Emoji> queue = new LinkedList<>();
		queue.add(new Emoji(n, 0, 0));
		visited[n][0] = true;
		
		int time = 0;
		int clip = 0;
		while(!queue.isEmpty()) {
			n = queue.peek().n;
			time = queue.peek().t;
			clip = queue.peek().c;
			queue.poll();
			if(n == s) break;
			
			// 1. 클립보드에 복사 
			if(n != clip) {
				if(!visited[n][n]) {
					queue.add(new Emoji(n, time+1, n));
					visited[n][n] = true;
				}
			}
			
			// 2. 붙여넣기 
			if(clip != 0 && n+clip <= 1000) {
				if(!visited[n+clip][clip]) {
					queue.add(new Emoji(n+clip, time+1, clip));
					visited[n+clip][clip] = true;
				}
			}
			
			// 3. 하나 삭제하기 
			if(n-1 >= 0) {
				if(!visited[n-1][clip]) {
					queue.add(new Emoji(n-1, time+1, clip));
					visited[n-1][clip] = true;
				}
			}
		}
		return time;
	}
	
	static class Emoji {
		int n, t, c;
		Emoji(int n, int t, int c) {
			this.n = n;
			this.t = t;
			this.c = c;
		}
	}
}
