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

public class boj_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		String word = br.readLine();
		int[] list = new int[26]; // 알파벳 리스트
		
		for(int i=0; i<word.length(); i++) {
			if(list[word.charAt(i)-97] == 0) {
				list[word.charAt(i)-97] = i;
			}
			if(i == 0) { // 'a'는 -2로 따로 지정
				list[word.charAt(i)-97] = -2;
			}
		}
		
		for(int i=0; i<list.length; i++) {
			if(list[i] == 0) { // 0인것들을 -1로 변환
				list[i] = -1;
			}
			else if(list[i] == -2) { // 'a'는 -2로 지정해놨던 것을 0으로 다시 변환
				list[i] = 0;
			}
			st.append(list[i]+" ");
		}
		
		System.out.print(st);
		
		br.close();
	}

}
