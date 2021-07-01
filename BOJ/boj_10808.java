package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.02 daily algo/commit
 * 
 * 짧은 풀이 참고
 * https://imksh.com/38
 * 아스키 코드 : 97부터 a~
 */

public class boj_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int[] list = new int[26];
		
		for(int i=0; i<word.length(); i++) {
			list[word.charAt(i)-97] += 1;
		}
		
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i]+" ");
		}
		
		br.close();
	}

}
