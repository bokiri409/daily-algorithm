package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.16 daily algo/commit
 * 
 * 최소공배수, 최대공약수 구하기
 * 유클리드 호제법 이용
 */

public class boj_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max, min = 0;
		int gcd, lcd = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		max = Math.max(N, M);
		min = Math.min(N, M);
		
		gcd = gcd(max, min);
		lcd = lcd(max, min, gcd);
		
		System.out.println(gcd);
		System.out.println(lcd);
		
		br.close();
	}
	
	static int gcd(int max, int min) {
		int gcd = 0;
		while(true) {
			if(max % min == 0) { // 나머지가 0이될때 나눈 수가 최대공약수가 된다.
				gcd = min;
				break;
			}
			else { // 나머지가 0이 아닐 때
				gcd = max % min; // 나머지가 다시 나누는 수가 된다.
				max = min;
				min = gcd;
			}
		}
		return gcd;
	}
	
	static int lcd(int max, int min, int gcd) {
		int lcd = (max/gcd) * (min/gcd) * gcd;
		return lcd;
	}

}
