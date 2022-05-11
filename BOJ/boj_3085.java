package BOJ;

import java.util.Scanner;

/*
 * 2022.05.11 daily algo/commit
 * 
 * Brute Force
 * ������ ��� ��� �� �غ���
 * 
 * ������ ���� �������� ������, �Ʒ��ʸ� üũ�ϸ� ��� ��츦 �� üũ�� �� �ִ�.
 * ������ �ٲ� �κи� �˻� �����ص� �ִ밪�� ���� �� �ִ�.
 * �ٲ��� ���� �κ��� �ٿ��� �ִ밪�� ���͵� �̹� �ش� �ٿ��� ��ȯ�ϸ鼭 �ִ밪�� ���ϱ� ������ �������!
 */

public class boj_3085 {
	
	static int[] dx = {0, 1};
	static int[] dy = {1, 0}; // ��, �Ʒ�

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] candy = new char[n][n];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			candy[i] = s.toCharArray();
		}
		
		int answer = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				char temp = candy[i][j];
				
				// ������ ��ȯ
				if(i+dx[0] >= 0 && i+dx[0] < n && j+dy[0] >= 0 && j+dy[0] < n) {
					candy[i][j] = candy[i+dx[0]][j+dy[0]];
					candy[i+dx[0]][j+dy[0]] = temp;
					answer = Math.max(answer, exchange(candy, i, i, j, j+1));
					// ��ȯ �ǵ�����
					candy[i+dx[0]][j+dy[0]] = candy[i][j];
					candy[i][j] = temp;
				}
				
				// �Ʒ��� ��ȯ
				if(i+dx[1] >= 0 && i+dx[1] < n && j+dy[1] >= 0 && j+dy[1] < n) {
					candy[i][j] = candy[i+dx[1]][j+dy[1]];
					candy[i+dx[1]][j+dy[1]] = temp;
					answer = Math.max(answer, exchange(candy, i, i+1, j, j));
					// ��ȯ �ǵ�����
					candy[i+dx[1]][j+dy[1]] = candy[i][j];
					candy[i][j] = temp;
				}
			}
		}
		System.out.println(answer);
	}
	
	// �˻��� ���� ��. (������ �Ͼ �� �Ǵ� �ุ �˻��ϸ� ��)
	public static int exchange(char[][] candy, int start_i, int end_i, int start_j, int end_j) {
		int max = 1; // ���ӵǴ� ���� �� ��
		
		/*
		// ��� ��� ���� �ٽ� �˻� => �ߺ��Ǵ� ���� ����.
		// ��
		for(int i=0; i<candy.length; i++) {
			int cnt = 1;
			for(int j=1; j<candy.length; j++) {
				if(candy[i][j-1] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		
		// �˻��� ��
		for(int j=0; j<candy.length; j++) {
			int cnt = 1;
			for(int i=1; i<candy.length; i++) {
				if(candy[i-1][j] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		*/
		
		// �ٲ� �κи� �˻� ���� 
		// �ٲ��� ���� �κп��� �ִ밪�� ���͵� �̹� �� �κп��� ��ȯ�ϸ鼭 �ִ밪�� ���⶧���� ���� ��� ��츦 �Ź� �� �˻����� �ʾƵ� �ȴ�.!
		// �˻��� ��
		for(int i=start_i; i<=end_i; i++) {
			int cnt = 1;
			for(int j=1; j<candy.length; j++) {
				if(candy[i][j-1] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		
		// �˻��� ��
		for(int j=start_j; j<=end_j; j++) {
			int cnt = 1;
			for(int i=1; i<candy.length; i++) {
				if(candy[i-1][j] == candy[i][j]) cnt += 1;
				else cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		
		return max; 
	}

}
