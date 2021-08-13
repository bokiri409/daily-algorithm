package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 2021.08.14 daily algo/commit
 * 
 * ���� ��α� : https://steady-coding.tistory.com/45
 */

public class boj_1181 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) { // ���� ª�� ������� ����
				if(s1.length() == s2.length()) { // ���� ������
					return s1.compareTo(s2); // ���� ��
				}
				else { // ���� �ٸ���
					return s1.length() - s2.length(); // ���� ��
				}
			}
		});
		
		System.out.println(words[0]);
		for(int i=0; i<words.length-1; i++) {
			if(words[i].equals(words[i+1])) {
				continue;
			}
			else {
				System.out.println(words[i+1]);
			}
		}
		
		br.close();
	}

}
