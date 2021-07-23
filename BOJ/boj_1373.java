package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.23 daily algo/commit
 * 
 * Ǯ��1 : 2���� -> 10���� -> 8����, 10������ �ٲ� �� longŸ�� �ʿ�
 * Ǯ��2 : 2���� (3�ڸ��� ���) -> 8���� �� �ٷ� ��ȯ����
 */

public class boj_1373 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		
		int n = 1; // 3�� ��� ���� ����
		int sum = 0;
		for(int i=S.length()-1; i>=0; i--) {
			sum += (S.charAt(i) - '0') * Math.pow(2, n-1);
			switch (n) {
			case 1:
				n++;
				break;
			case 2:
				n++;
				break;
			case 3:
				n = 1;
				sb.insert(0, sum);
				sum = 0;
				break;
			}
		}
		if(sb.length() == 0 || sum != 0) { // ó������ 0�� ��� ��������� �Ѵ�!
			sb.insert(0, sum);
		}
		System.out.print(sb);
		br.close();
	}

}
