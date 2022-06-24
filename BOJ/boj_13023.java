package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 2022.06.24 daily algorithm
 * 
 * 간선리스트/인접리스트/인접행렬 혼합 사용
 * A -> B : 간선리스트 사용 
 * C -> D : 간선리스트 사용
 * -------
 * B -> C : 인접 행렬 사용(연결여부만 확인하면 됨)
 * D -> E : 인접리스트 사용(인접행렬 사용 시 시간초과) 모든 정점을 확인하는 것 보다, 연결되어 있는 정점들만 확인하는 것이 효율적이다. 
 */

public class boj_13023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 사람 수 
		int m = sc.nextInt(); // 관계 수 
		
		int[][] matrix = new int[n][n]; // 인접행렬 
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 인접리스트 
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		ArrayList<Edge> edges = new ArrayList<>(); // 간선리스트 
		for(int i=0; i<m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			matrix[from][to] = matrix[to][from] = 1;
			list.get(from).add(to); list.get(to).add(from);
			edges.add(new Edge(from, to)); edges.add(new Edge(to, from));
		}
		sc.close();
		
		m *=  2;
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				int A = edges.get(i).from;
				int B = edges.get(i).to;
				int C = edges.get(j).from;
				int D = edges.get(j).to;
				if(A == C || A == B || A == D || B == C || C == D || B == D) continue;
				if(matrix[B][C] == 0) continue; // 연결 x 
				for(int E : list.get(D)) {
					if(E == A || E == B || E == C || E == D) continue;
					System.out.println(1);
					System.exit(0);
				}
				// 인접행렬로 연결 여부를 확인하면 시간초과!
//				for(int E=0; E<n; E++) {
//					if(E == A || E == B || E == C || E == D) continue;
//					if(matrix[D][E] == 1) {
//						System.out.println(1);
//						System.exit(0);
//					}
//				}
			}
		}
		System.out.println(0);
	}

}

class Edge {
	int from, to;
	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
}