package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.13 daily algo/commit
 * 
 * Ư�� ��ġ ���� ���� : https://mozi.tistory.com/501
 * Ư�� ��ġ ���� �߰� : https://mozi.tistory.com/502?category=987369
 * 
 * => ���� �ΰ��� �̿��� �ٸ�Ǯ��(�ð��� �� ����)
 * https://dundung.tistory.com/6
 */

public class boj_1406 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static String cursor, word = "";

	public static void main(String[] args) throws IOException {
		
		String S = br.readLine();
		sb.append("F").append(S).append("B");
		int m = sb.length() - 1; // Ŀ�� ������
		int N = Integer.parseInt(br.readLine());
		editor(N, m);
		
		System.out.println("���" + sb);
		System.out.print(sb.substring(1, sb.length()-1));
		br.close();
	}
	
	static void editor(int N, int m) throws IOException {
		for(int i=0; i<N; i++) { // Ŀ��
			st = new StringTokenizer(br.readLine());
			cursor = st.nextToken();
			if(cursor.equals("P")) {
				word = st.nextToken();
			}
			if(cursor.equals("L")) { // Ŀ�� �������� �� ĭ �ű�
				if(m > 1) {
					m -= 1;
				}
			}
			else if(cursor.equals("D")) { // Ŀ�� ���������� �� ĭ �ű�
				if(m < sb.length()-1) {
					m += 1;
				}
			}
			else if(cursor.equals("B")) { // ����
				if(m > 1) {
					sb.deleteCharAt(m-1);
					m -= 1;
				}
			}
			else { // ���� �߰�
				if(m == 0) {
					sb.insert(m+1, word);
					m += 1;
				}
				else {
					sb.insert(m, word);
					m += 1;
				}
			}
		}
	}

}
