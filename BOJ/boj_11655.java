package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.08 daily algo/commit
 * 
 * �ƽ�Ű�ڵ� ���ڷ� ��ȯ �� ĳ���� ���ָ� �ȴ�.
 * ((char) 65)
 */

public class boj_11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String SS = "";
		String S = br.readLine();
		
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) >= 65 && S.charAt(i) <= 90) { // �빮���� ��
				int n = S.charAt(i) + 13;
				if(n > 90) { // ���� ���� ��
					n = n - 90 + 64;
					SS += ((char) n); // ���ڷ� ��ȯ
				}
				else {
					SS += ((char) n);
				}
			}
			else if(S.charAt(i) >= 97 && S.charAt(i) <= 122){ // �ҹ���
				int n = S.charAt(i) + 13;
				if(n > 122) {
					n = n - 122 + 96;
					SS += ((char) n);
				}
				else {
					SS += ((char) n);
				}
			}
			else { // ������ ��
				SS += S.charAt(i);
			}
		}
		System.out.print(SS);
		br.close();
	}

}
