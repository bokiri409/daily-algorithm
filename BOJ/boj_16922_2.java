package BOJ;

import java.util.Scanner;

/*
 * 2021.12.01 daily algo/commit
 * 
 * Brute Force
 * ������ 1,5,10,50�� ����� ������ �ľ��ϸ� �ȴ�. 
 * ���� ������ ������ �˸� ������ �ϳ��� �� �� �����Ƿ� 3�� for���� �̿��Ͽ� �����ϰ� Ǯ�� �����ϴ�.
 */

public class boj_16922_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] visited = new boolean[1001];
		
		int answer = 0;
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N-i; j++) {
				for(int k=0; k<=N-i-j; k++) {
					int l = N-i-j-k;
					int sum = i+j*5+k*10+l*50;
					if(!visited[sum]) {
						visited[sum] = true;
						answer += 1;
					}
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
