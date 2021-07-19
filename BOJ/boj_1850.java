package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.19 daily algo/commit
 * 
 * �Է� : ù° �ٿ� �� �ڿ��� A�� B�� �̷�� 1�� ������ �־�����. �ԷµǴ� ���� 263���� ���� �ڿ����̴�.
 * 
 * ����Ÿ��
 * byte  : 1byte,  -2^7 ~ (2^7-1)
 * short : 2byte, -2^15 ~ (2^15-1)
 * char  : 2byte,     0 ~ (2^16-1)
 * int   : 4byte, -2^31 ~ (2^31-1)
 * long  : 8byte, -2^63 ~ (2^63-1) 
 * 
 * 
 * �Ϲ� print�� �ð��ʰ�
 * => StringBuilder ���!
 */

public class boj_1850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		Long max = Math.max(A, B);
		Long min = Math.min(A, B);
		Long gcd; // �ִ�����
		
		while(true) {
			if(max % min == 0) {
				gcd = min;
				break;
			}
			else {
				gcd = min;
				min = max % gcd;
				max = gcd;
			}
		}
		
		for(int i=0; i<gcd; i++) {
			sb.append(1);
		}
		System.out.print(sb);
		
		br.close();
	}

}
