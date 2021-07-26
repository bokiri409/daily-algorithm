package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.26 daily algo/commit
 */

public class boj_2089 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int a = 0;
		while(true) {
//			if(Math.abs(Math.round(N/-2)) < 2) {
//				sb.insert(0, Math.abs(Math.round(N/-2)));
//				break;
//			}
			if(Math.abs(N) < 1) {
//				sb.insert(0, Math.abs(N));
				break;
			}
//			System.out.println(Math.abs(N%-2));
			sb.insert(0, Math.abs(N%-2)); // -2로 나눈 나머지
//			System.out.println("@@@"+Math.round(N/-2.0));
			N = (int) Math.round(N/-2.0);
		}
		if(sb.length() == 0) {
			sb.append(0);
		}
		System.out.print(sb);
		br.close();
	}

}
