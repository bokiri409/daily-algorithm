package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.09.09 daily algo/commit
 * 
 * DFS : �ڽź��� ���� ��� �� + �ڽź��� ū ��� �� = ��ü ��� �� -1
 * ���� : https://maetdori.tistory.com/entry/%EB%B0%B1%EC%A4%80-2458-%ED%82%A4-%EC%88%9C%EC%84%9C-JAVA?category=852190
 * ����� ���� : ���� 2458 Ű����
 * 
 * ��������� ���� = �ش� ������ ���� ������
 * 		     ���� = �ش� ������ ���� ������
 * 
 * ��������, �������� ��츦 ������ ���������� �� �� ������ / ���������� ��� ������
 */

public class prg_L3_���� {
	
	static int n = 5;
//	static int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
	static int[][] results = {{1, 2}, {4, 5}, {3, 4}, {2, 3}};
	static int[][] adjMatrix;

	public static void main(String[] args) {
		System.out.println(solution(n, results));
	}
	
	public static int solution(int n, int[][] results) {
        int answer = 0;
        adjMatrix = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
    		adjMatrix[results[i][0]][results[i][1]] = 1;
        }
        
        for(int i=1; i<n+1; i++) {
        	int result = bfs(i, n);
        	if(result == n-1) {
				answer++;
			}
        }
        
        return answer;
    }
	
	private static int bfs(int current, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] rank = new int[n+1];
		boolean[] visited = new boolean[n+1];
		
		rank[current] = 2; // ù ������ ��,���� ��� Ž��
		q.offer(current);
		
		int high = 0;
		int low = 0;
		
		while(!q.isEmpty()) {
			current = q.poll();
			if((rank[current] == 1 || rank[current] == 2)) { // ���� ����
				for(int i=1; i<=n; i++) {
					if(adjMatrix[i][current] == 1) {
						if(!visited[i]) {
							high += 1;
							q.offer(i);
						}
						visited[i] = true;
						rank[i] = 1;
					}
				}
			}
			if(rank[current] == -1 || rank[current] == 2) { // ���� ����
				for(int i=1; i<=n; i++) {
					if(adjMatrix[current][i] == 1) {
						if(!visited[i]) {
							low += 1;
							q.offer(i);
						}
						visited[i] = true;
						rank[i] = -1;
					}
				}
			}
		}
		return high+low;
	}

}
