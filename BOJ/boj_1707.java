package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 2022.06.24 daily algorithm
 * 
 * DFS
 * 인접리스트를 이용하여 DFS탐색을 통해 해당 정점과 인접한 노드들이 각각 다른 팀인지 확인하고
 * 같은팀이면 false를 리턴해준다.
 * info[]배열을 사용하여 1팀, 2팀으로 분류하고, 0이면 방문하지 않은 노드로 체크한다. (visited 배열 사용 x)
 * 
 * 그래프의 모든 노드들이 이어져 있지 않을 수 있기 때문에,
 * 각 노드들의 방문 여부를 모두 확인하여 끝까지 체크해보고 false가 나오는지 확인하여 하나라도 false일 시 
 * NO를 출력해준다.
 */

public class boj_1707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int tc=0; tc<t; tc++) {
			int v = sc.nextInt(); // 정점 개수 
			int e = sc.nextInt(); // 간선 개수 
			
			int[] info = new int[v+1]; // 팀 정보 
			ArrayList<ArrayList<Integer>> edges = new ArrayList<>(); // 인접리스트 
			for(int j=0; j<=v; j++) {
				edges.add(new ArrayList<>());
			}
			for(int j=0; j<e; j++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edges.get(from).add(to);
				edges.get(to).add(from);
			}
			// 그래프가 전부 연결되어 있지 않을 수 있다.
			boolean flag = true;
			for(int i=1; i<=v; i++) {
				if(info[i] == 0) {
					if(!dfs(i, edges, info, 1)) {
						flag = false;
						break;
					}
				}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}

	public static boolean dfs(int v, ArrayList<ArrayList<Integer>> edges, int[] info, int c) {
		info[v] = c; // 팀
		
		for(int i : edges.get(v)) {
			if(info[i] == 0) {
				if(!dfs(i, edges, info, 3-c)) {
					return false;
				}
			}
			else if(info[v] == info[i]){
				return false;
			}
		}
		return true;
	}

}

