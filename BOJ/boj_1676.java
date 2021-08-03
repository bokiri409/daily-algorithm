package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.08.03 daily algo/commit
 * 
 * ���� ���丮���� ���ϱ⿡�� 500!�� �ʹ� ũ��.
 * �� ���� 0�� ���� �� �ִ� ������� ���ϱ� => 2*5 �ѽֿ� 0 1��
 */

public class boj_1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = N/5;
		N /= 5;
		while(N >= 5) {
			if(N == 0) {
				break;
			}
			N /= 5;
			cnt += N;
		}
		System.out.println(cnt);
		br.close();
	}

}
