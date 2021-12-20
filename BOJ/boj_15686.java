package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 2021.12.20 daily algo/commit
 * 
 * Brute Force, Combination
 */

public class boj_15686 {
	
	static int cnt = 0;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Position> stores = new ArrayList<>();
		ArrayList<Position> houses = new ArrayList<>();
		
		int[][] city = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				city[i][j] = sc.nextInt();
				if(city[i][j] == 2) stores.add(new Position(i, j));
				if(city[i][j] == 1) houses.add(new Position(i, j));
			}
		}
		
		sc.close();
		boolean[] visited = new boolean[stores.size()];
		combination(stores, houses, visited, stores.size(), M, 0);
		System.out.println(ans);
	}
	
	public static void combination(ArrayList<Position> stores, ArrayList<Position> houses, boolean[] visited, int n, int r, int start) {
		if(r == 0) {
			cnt = 0;
			for(int i=0; i<houses.size(); i++) {
				int min = Integer.MAX_VALUE;
				int house_x = houses.get(i).x;
				int house_y = houses.get(i).y;
				for(int j=0; j<visited.length; j++) {
					// 폐업하지 않은 치킨집
					if(visited[j]) {
						int store_x = stores.get(j).x;
						int store_y = stores.get(j).y;
						int dist = Math.abs(store_x-house_x) + Math.abs(store_y-house_y);
						if(min > dist) min = dist;
					}
				}
				cnt += min;
			}
			if(ans > cnt) ans = cnt;
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(stores, houses, visited, n, r-1, i+1);
			visited[i] = false;
		}
	}

}

class Position{
	int x, y;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}