package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2021.02.06 daily algo/commit
 * 
 * GRAPH
 * 인접행렬 => 메모리초과
 * 인접리스트로 메모리 효율성 높이기
 */

public class prg_L3_가장먼노드 {
	
	static ArrayList<ArrayList<Integer>> map;
	static int n = 6;
	static int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
//	static int n = 5;
//	static int[][] edge = {{4, 3}, {3, 2}, {2, 3}, {1, 2}, {2, 4}, {5, 2}};
	static int[] distance = new int[n+1]; // 1번 노드에서 각 노드까지의 거리

	public static void main(String[] args) {
		System.out.println(solution(n, edge));
		System.out.println(Arrays.toString(distance));
	}
	
	public static int solution(int n, int[][] edge) {
//        map = new int[n+1][n+1];
		map = new ArrayList<ArrayList<Integer>>();
		// n개의 ArrayList 추가
		for(int i=0; i<=n; i++) {
			map.add(new ArrayList<Integer>());
		}
		
        for(int i=0; i<edge.length; i++) {
        	map.get(edge[i][0]).add(edge[i][1]);
        	map.get(edge[i][1]).add(edge[i][0]);
//        	map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = 1;
        }
        bfs();
        
        // 가장 높은 레벨
        int max = 0;
        for(int i=1; i<=n; i++) {
        	max = Math.max(max, distance[i]);
        }
        
        // 개수
        int answer = 0;
        for(int i=2; i<=n; i++) {
        	if(distance[i] == max) answer += 1;
        }
        
        return answer;
    }
	
	
	public static void bfs() {
		Queue<Level> q = new LinkedList<Level>();
		boolean[] visited = new boolean[n+1];
		q.offer(new Level(1, 1));
		visited[1] = true;
		
		while(!q.isEmpty()) {
			Level current = q.poll();
			distance[current.node] = current.lvl;
			
			for(int i=0; i<map.get(current.node).size(); i++) {
//				if(!visited[i] && map[current.node][i] == 1) {
				if(!visited[map.get(current.node).get(i)]) {
					q.offer(new Level(map.get(current.node).get(i), current.lvl+1));
					visited[map.get(current.node).get(i)] = true;
				}
			}
		}
		return;
	}

}

class Level {
	int node, lvl;
	Level(int node, int lvl) {
		this.node = node;
		this.lvl = lvl;
	}
}
