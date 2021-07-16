package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.16 daily algo/commit
 * 
 * 최소공배수 구하기
 */

public class boj_1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int A, B = 0;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			int max = Math.max(A, B);
			int min = Math.min(A, B);
			int lcd = getLCD(max, min, A, B);
			System.out.println(lcd);
		}
		
		br.close();
	}
	
	static int getLCD(int max, int min, int A, int B) {
		int lcd, gcd = 0;
		while(true) {
			if(max % min == 0) {
				gcd = min;
				int a = A / gcd;
				int b = B / gcd;
				lcd = a * b * gcd;
				break;
			}
			else {
				gcd = max % min;
				max = min;
				min = gcd;
			}
		}
		return lcd;
	}

}
