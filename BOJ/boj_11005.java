package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.21 daily algo/commit
 * 
 * StringBuilder insert(index, " "); ���ϴ� ���� ����
 * �ƽ�Ű �ڵ� : (A) 65~, (a) 97~
 *
 * ª�� Ǯ�� : https://dalconbox.tistory.com/226
 */

public class boj_11005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.print(cal(N, B, sb));
		br.close();
	}
	
	static StringBuilder cal(int N, int B, StringBuilder sb) { // ���� ���
		int num = 0;
		char s = 0;
		while(true) {
			num = N % B; // ������
			if(B > N) { // ���� ��� ��
				if(num >= 10) {
					s = (char) (num + 55);
					sb.insert(0, s);
				}
				else {
					sb.insert(0, num);
				}
				break;
			}
			else {
				if(num >= 10) {
					s = (char) (num + 55);
					sb.insert(0, s);
				}
				else {
					sb.insert(0, num);
				}
			}
			N /= B; // N�� �ٽ� ���� ��
		}
		return sb;
	}

}
