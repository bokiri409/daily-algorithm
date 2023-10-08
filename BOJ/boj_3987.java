package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3987 {
	
	static int N, M, pr, pc;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=1; j<=M; j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		pr = Integer.parseInt(st.nextToken());
		pc = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<4; i++) {
			move(i);
			
			if(infinite) {
				System.out.println(direction + "\n" + "Voyager");
				return;
			}
		}
		
		System.out.println(direction + "\n" + max);
	}
	
	static int max = 0;
	static char direction;
	static Boolean infinite = false;
	static char[] dir = {'U', 'R', 'D', 'L'};
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void move(int n) {
		int cnt = 0;
		char d;
		if(n == 0) d = 'u';
		else if(n == 1) d = 'r';
		else if(n == 2) d = 'd';
		else d = 'l';
		
		int x = pr;
		int y = pc;
		char[][] checkMap = new char[N+1][M+1];
		checkMap[x][y] = d;
		
		while(true) {
			// 블랙홀 
			if(map[x][y] == 'C') break;
			else if(map[x][y] == '/') {
				if(d == 'u') d = 'r';
				else if(d == 'r') d = 'u';
				else if(d == 'd') d = 'l';
				else d = 'd';
			}
			else if(map[x][y] == '\\') {
				if(d == 'u') d = 'l';
				else if(d == 'r') d = 'd';
				else if(d == 'd') d = 'r';
				else d = 'u';
			}
			
			// 이동 
			if(d == 'u') x -= 1;
			else if(d == 'r') y += 1;
			else if(d == 'd') x += 1;
			else y -= 1;

			cnt += 1;
			
			// 우주 밖 
			if(x <= 0 || x > N || y <= 0 || y > M) break;
			
			// 반복일 때 
			if(checkMap[x][y] == d) {
				infinite = true;
				direction = dir[n];
				return;
			}
			
			checkMap[x][y] = d;
		}
		
		
		if(max < cnt) {
			max = cnt;
			direction = dir[n];
		}
	}
	
}
