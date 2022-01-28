package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2021.01.28 daily algo/commit
 */

public class boj_17471 {
	
	static int N, sum;
	static int[][] map;
	static int[] arr, areas, population;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		population = new int[N+1];
		sum = 0;
		for(int i=1; i<=N; i++) {
			population[i] = sc.nextInt();
			sum += population[i]; // �� �α�
		}
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			int n = sc.nextInt();
			for(int j=0; j<n; j++) {
				map[i][sc.nextInt()] = 1; 
			}
		}
		sc.close();
		
		// ����Ǿ� �ִ� ���� ����
		areas = new int[N+1];
//		System.out.println(Arrays.toString(areas));
//		check(1, areas);
//		System.out.println(Arrays.toString(areas));
		
		// ���ű� ������(1��~ N/2�� �̱�)
		for(int i=1; i<=N/2; i++) {
			arr = new int[i];
			combination(N, i, 1, arr, 0);
		}
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	public static void combination(int n, int r, int start, int[] arr, int depth) {
		if(r == 0) {
			/* �����ڵ� - ������ �ִ� ������ üũ�س��� ����
			// A���ű� ���� Ȯ��
			int A = areas[arr[0]];
			for(int i=1; i<arr.length; i++) {
				// ���� x
				if(A != areas[arr[i]]) return;
				int chk = 0;
				for(int j=0; j<arr.length; j++) {
					if(i == j) continue; // ���� ���������� Ȯ�� x
					if(map[arr[i]][arr[j]] == 0) chk++;
				}
				// ������ �ȵǾ� ���� ��
				if(chk == arr.length-1) return;
			}
			// B���ű� 
			int[] arr2 = new int[N-arr.length];
			int idx = 0;
			int idx2 = 0;
			for(int i=1; i<=N; i++) {
				if(idx >= arr.length || arr[idx] != i) {
					arr2[idx2] = i;
					idx2++;
					continue;
				}
				idx++;
				
			}
			// B���ű� ���� Ȯ��
			int B = areas[arr2[0]];
			for(int i=1; i<arr2.length; i++) {
				// ���� x
				if(B != areas[arr2[i]]) return;
				int chk = 0;
				for(int j=0; j<arr2.length; j++) {
					if(i == j) continue; // ���� ���������� Ȯ�� x
					if(map[arr2[i]][arr2[j]] == 0) chk++;
				}
				// ������ �ȵǾ� ���� ��
				if(chk == arr2.length-1) return;
			}
			*/
			boolean[] visitedA = new boolean[arr.length];
			// A���ű� ���� Ȯ��
			Queue<Integer> qA = new LinkedList<Integer>();
			qA.add(arr[0]);
			visitedA[0] = true;
			while(!qA.isEmpty()) {
				int a = qA.poll();
				for(int i=0; i<arr.length; i++) {
					// ���� x
					if(!visitedA[i] && map[a][arr[i]] == 1) {
						visitedA[i] = true;
						qA.add(arr[i]);
					}
				}
			}
			for(int i=0; i<visitedA.length; i++) {
				if(!visitedA[i]) return;
			}
			
			// B���ű� 
			int[] arr2 = new int[N-arr.length];
			int idx = 0;
			int idx2 = 0;
			for(int i=1; i<=N; i++) {
				if(idx >= arr.length || arr[idx] != i) {
					arr2[idx2] = i;
					idx2++;
					continue;
				}
				idx++;
				
			}
			
			boolean[] visitedB = new boolean[arr2.length];
			// B���ű� ���� Ȯ��
			Queue<Integer> qB = new LinkedList<Integer>();
			qB.add(arr2[0]);
			visitedB[0] = true;
			while(!qB.isEmpty()) {
				int a = qB.poll();
				for(int i=0; i<arr2.length; i++) {
					// ���� x
					if(!visitedB[i] && map[a][arr2[i]] == 1) {
						visitedB[i] = true;
						qB.add(arr2[i]);
					}
				}
			}
			for(int i=0; i<visitedB.length; i++) {
				if(!visitedB[i]) return;
			}
			
			int s = 0;
			for(int i=0; i<arr.length; i++) {
				s += population[arr[i]];
			}
			if(min > Math.abs(s-(sum - s))) min = Math.abs(s-(sum - s));
			return;
		}
		for(int i=start; i<=N; i++) {
			arr[depth] = i;
			combination(n, r-1, i+1, arr, depth+1);
		}
	}
	
	/* �������� ���� ���� üũ - �ʿ����
	public static void check(int n, int[] areas) {
		int level = 1;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(n);
		while(!q.isEmpty()) {
			int area = q.poll();
			visited[area] = true;
			areas[area] = level;
			for(int i=1; i<=N; i++) {
				if(!visited[i] && map[area][i] == 1) {
					q.add(i);
				}
			}
			if(q.isEmpty()) {
				for(int i=1; i<=N; i++) {
					if(areas[i] == 0) {
						q.add(i);
						level += 1;
						break;
					}
				}
			}
		}
	}
	*/

}
