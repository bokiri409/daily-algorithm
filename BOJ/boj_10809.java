package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.02 daily algo/commit
 * 
 * ª�� Ǯ�� ����
 * https://imksh.com/38
 * �ƽ�Ű �ڵ� : 97���� a~
 */

public class boj_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		String word = br.readLine();
		int[] list = new int[26]; // ���ĺ� ����Ʈ
		
		for(int i=0; i<word.length(); i++) {
			if(list[word.charAt(i)-97] == 0) {
				list[word.charAt(i)-97] = i;
			}
			if(i == 0) { // 'a'�� -2�� ���� ����
				list[word.charAt(i)-97] = -2;
			}
		}
		
		for(int i=0; i<list.length; i++) {
			if(list[i] == 0) { // 0�ΰ͵��� -1�� ��ȯ
				list[i] = -1;
			}
			else if(list[i] == -2) { // 'a'�� -2�� �����س��� ���� 0���� �ٽ� ��ȯ
				list[i] = 0;
			}
			st.append(list[i]+" ");
		}
		
		System.out.print(st);
		
		br.close();
	}

}
