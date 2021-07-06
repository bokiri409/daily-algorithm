package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.06 daily algo/commit
 * 
 * Stringbuilder �ʱ�ȭ : sb.delete(ù��°, ������);
 */

public class boj_10820 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null) {
			System.out.println(check(line));
			sb.delete(0,sb.length());
		}
		
		br.close();
	}
	
	private static StringBuilder check(String line) {
		int[] num = new int[4];
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i) >= 97 && line.charAt(i) <= 122) { // �ҹ��� �Ǻ�
				num[0] += 1;
			}
			else if(line.charAt(i) >= 65 && line.charAt(i) <= 90) { // �빮�� �Ǻ�
				num[1] += 1;
			}
			else if(line.charAt(i) >= 48 && line.charAt(i) <= 57) { // ���� �Ǻ�
				num[2] += 1;
			}
			else { // ���� ����
				num[3] += 1;
			}
		}
		
		for(int i=0; i<4; i++) {
			sb.append(num[i]).append(" ");
		}
		return sb;
	}

}
