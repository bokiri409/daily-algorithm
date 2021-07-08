package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.08 daily algo/commit
 * 
 * 아스키코드 문자로 변환 시 캐스팅 해주면 된다.
 * ((char) 65)
 */

public class boj_11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String SS = "";
		String S = br.readLine();
		
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) >= 65 && S.charAt(i) <= 90) { // 대문자일 때
				int n = S.charAt(i) + 13;
				if(n > 90) { // 범위 넘을 때
					n = n - 90 + 64;
					SS += ((char) n); // 문자로 변환
				}
				else {
					SS += ((char) n);
				}
			}
			else if(S.charAt(i) >= 97 && S.charAt(i) <= 122){ // 소문자
				int n = S.charAt(i) + 13;
				if(n > 122) {
					n = n - 122 + 96;
					SS += ((char) n);
				}
				else {
					SS += ((char) n);
				}
			}
			else { // 숫자일 때
				SS += S.charAt(i);
			}
		}
		System.out.print(SS);
		br.close();
	}

}
