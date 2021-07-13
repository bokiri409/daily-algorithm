package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.13 daily algo/commit
 * 
 * 특정 위치 문자 삭제 : https://mozi.tistory.com/501
 * 특정 위치 문자 추가 : https://mozi.tistory.com/502?category=987369
 * 
 * => 스택 두개를 이용한 다른풀이(시간이 더 빠름)
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
		int m = sb.length() - 1; // 커서 움직임
		int N = Integer.parseInt(br.readLine());
		editor(N, m);
		
		System.out.println("결과" + sb);
		System.out.print(sb.substring(1, sb.length()-1));
		br.close();
	}
	
	static void editor(int N, int m) throws IOException {
		for(int i=0; i<N; i++) { // 커서
			st = new StringTokenizer(br.readLine());
			cursor = st.nextToken();
			if(cursor.equals("P")) {
				word = st.nextToken();
			}
			if(cursor.equals("L")) { // 커서 왼쪽으로 한 칸 옮김
				if(m > 1) {
					m -= 1;
				}
			}
			else if(cursor.equals("D")) { // 커서 오른쪽으로 한 칸 옮김
				if(m < sb.length()-1) {
					m += 1;
				}
			}
			else if(cursor.equals("B")) { // 삭제
				if(m > 1) {
					sb.deleteCharAt(m-1);
					m -= 1;
				}
			}
			else { // 문자 추가
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
