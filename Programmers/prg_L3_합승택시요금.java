package Programmers;

/*
 * 2021.09.21 daily algo/commit
 * 
 * �÷��̵� ����
 * i == j �� �� 0�� �־��ִ� �� ����
 */

public class prg_L3_�ս��ýÿ�� {
	
	static int n = 6; // ��� ��
	static int s = 4; // ��� ����
	static int a = 6; // A�� ��������
	static int b = 2; // B�� ��������
	static int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
	
	static int[][] adjMatrix;

	public static void main(String[] args) {
		System.out.println(solution(n, s, a, b, fares));
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        adjMatrix = new int[n+1][n+1];
        for(int i=1; i<n+1; i++) {
        	for(int j=1; j<n+1; j++) {
        		if(i == j) {
        			adjMatrix[i][j] = 0;
        			continue;
        		}
        		adjMatrix[i][j] = 1000000;
        	}
        }
        for(int i=0; i<fares.length; i++) {
        	adjMatrix[fares[i][0]][fares[i][1]] = adjMatrix[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k=1; k<n+1; k++) { // ������
        	for(int i=1; i<n+1; i++) { // �����
        		if(i == k) continue;
        		for(int j=1; j<n+1; j++) { // ������
        			if(j == k || i == j) continue;
        			adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
        		}
        	}
        }
        
        int answer = adjMatrix[s][a] + adjMatrix[s][b];
        // �ս��ϴ� ���
        for(int i=1; i<n+1; i++) {
        	answer = Math.min(answer, adjMatrix[s][i] + adjMatrix[i][a] + adjMatrix[i][b]);
        }
        
        return answer;
    }

}
