package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 2021.12.07 daily algo/commit
 * 
 * DFS�� �̿��Ͽ� ��� ���� ���ϰ� ���̵Ǵ� �迭 �Ѱ��� ����ϰ��� ������ �ð��ʰ�.
 * 
 * ������3, ���ϱ�2 �� ��
 * ���� 3���� ������ �������� Ƚ���� ���ϰ� ���� ���� ������ �������� ���� �����̹Ƿ� �������� �����Ѵ�.
 * ���� ���ϱ� 2�� ���� Ŀ�����ۿ� �����Ƿ� 3���� ������ �������� Ƚ���� ���� ������ �������� �������ָ� �ȴ�.
 * 
 * compare ���� Long���� ���� return���� long���� ��ȯ����� ��
 */

public class boj_16936 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] arr = new long[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][1] = sc.nextLong();
			long n = arr[i][1];
			while(true) {
				if(n % 3 == 0) { // 3���� ������ �������� Ƚ��
					arr[i][0] += 1;
					n /= 3;
				}
				else break;
			}
		}
		
		Arrays.sort(arr, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) {
					// 0��° �ε����� ������ 1��° �ε����� ��������
//					return (o1[1] - o2[1]); 
					return Long.compare(o1[1], o2[1]);
				}
				else {
					// 0��° �ε��� ��������
//					return (o2[0] - o1[0]);
					return Long.compare(o2[0], o1[0]);
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i][1]+" ");
		}
		
		sc.close();
	}
	
}
