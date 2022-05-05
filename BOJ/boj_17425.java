package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.05.05 daily algo/commit
 * Math
 * ȿ������ �ð����⵵�� �� ��������.
 * �׽�Ʈ���̽����� �ٽ� �� ���ϸ� �ð��� �����ɸ��Ƿ� 
 * 1000000���� ��� ����� ���� �̸� ���س��� �´� ���� �����´�.
 */

public class boj_17425 {
	static final int max = 1000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// �� ���� ����� ���� �̸� �迭�� ���س��´�.
		long[] list = new long[max+1];
		for(int i=1; i<=max; i++) {
			for(int j=1; i*j<=max; j++) {
				list[i*j] += i;
			}
		}
		
		// �̸� �������� ���س��� �ڿ��� ���� ��� ���� �ʿ䰡 ���� �ȴ�.
		for(int i=2; i<=max; i++) {
			list[i] += list[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
//			int sum = 0;
//			for(int i=1; i<=n; i++) {
//				sum += list[i];
//			}
			sb.append(list[n] + "\n");
		}
		System.out.println(sb);
		
	}

}
