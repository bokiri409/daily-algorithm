package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 2021.08.14 daily algo/commit
 * 
 * 참고 블로그 : https://steady-coding.tistory.com/45
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
			public int compare(String s1, String s2) { // 길이 짧은 순서대로 정렬
				if(s1.length() == s2.length()) { // 길이 같으면
					return s1.compareTo(s2); // 사전 순
				}
				else { // 길이 다르면
					return s1.length() - s2.length(); // 길이 순
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
