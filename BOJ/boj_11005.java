package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.21 daily algo/commit
 * 
 * StringBuilder insert(index, " "); 원하는 곳에 삽입
 * 아스키 코드 : (A) 65~, (a) 97~
 *
 * 짧은 풀이 : https://dalconbox.tistory.com/226
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
	
	static StringBuilder cal(int N, int B, StringBuilder sb) { // 진법 계산
		int num = 0;
		char s = 0;
		while(true) {
			num = N % B; // 나머지
			if(B > N) { // 진법 계산 끝
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
			N /= B; // N은 다시 몫이 됨
		}
		return sb;
	}

}
