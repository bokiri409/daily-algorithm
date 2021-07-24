package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.24 daily algo/commit
 */

public class boj_1212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();
		
		for(int i=0; i<num.length(); i++) {
			int n = 0;
			n = num.charAt(i) - '0';
			sb.append(cal(n));
		}
//		for(int i=0; i<sb.length(); i++) { // 이건 왜 안되지?
//			if(sb.charAt(i) == '0') {
//				System.out.println(sb.charAt(i));
//				sb.deleteCharAt(i);
//				System.out.println("@@@"+sb);
//			}
//			else {
//				break;
//			}
//		}
		
		while(true) {
			if(sb.length() == 1) {
				break;
			}
			int i=0;
			if(sb.charAt(i) == '0') {
				sb.deleteCharAt(i);
			}
			else {
				break;
			}
			i++;
		}
		
		System.out.print(sb);
		br.close();
	}
	
	static StringBuilder cal(int n) {
		StringBuilder sb = new StringBuilder();
		while(true) {
			sb.insert(0, n%2);
			if(n/2 == 0) {
				break;
			}
			n /= 2;
		}
		if(sb.length() == 1) {
			sb.insert(0, 0);
			sb.insert(0, 0);
		}
		else if(sb.length() == 2) {
			sb.insert(0, 0);
		}
		
		return sb;
	}

}
