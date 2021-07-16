package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.16 daily algo/commit
 * 
 * �ּҰ����, �ִ����� ���ϱ�
 * ��Ŭ���� ȣ���� �̿�
 */

public class boj_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max, min = 0;
		int gcd, lcd = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		max = Math.max(N, M);
		min = Math.min(N, M);
		
		gcd = gcd(max, min);
		lcd = lcd(max, min, gcd);
		
		System.out.println(gcd);
		System.out.println(lcd);
		
		br.close();
	}
	
	static int gcd(int max, int min) {
		int gcd = 0;
		while(true) {
			if(max % min == 0) { // �������� 0�̵ɶ� ���� ���� �ִ������� �ȴ�.
				gcd = min;
				break;
			}
			else { // �������� 0�� �ƴ� ��
				gcd = max % min; // �������� �ٽ� ������ ���� �ȴ�.
				max = min;
				min = gcd;
			}
		}
		return gcd;
	}
	
	static int lcd(int max, int min, int gcd) {
		int lcd = (max/gcd) * (min/gcd) * gcd;
		return lcd;
	}

}
