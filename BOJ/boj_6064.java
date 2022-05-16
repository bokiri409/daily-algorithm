package BOJ;

import java.util.Scanner;

/*
 * 2022.05.16 daily algo/commit
 * 
 * Brute Force 
 * 모든 경우에 -1을 하고 나머지로 규칙을 구하면 더 쉽다.
 */

public class boj_6064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int g = gcd(m, n);
			int l = lcm(m, n, g);
			
			int answer = -1;
			int year = 0;
			// n또는 m을 기준으로 배수만 검사한다.
			for(int k=0; ; k++) {
				year = k * m + x;
				if(year > l) break;
				if(year % n == y || (year % n == 0 && n == y)) {
					answer = year;
					break;
				}
			}
			System.out.println(answer);
			
			// 전부 다 검사하면 시간초과
//			loop:
//			for(int j=1; j<=l; j++) {
//				if(j % m == x) {
//					if(j % n == y) {
//						year = j;
//						break loop;
//					}
//				}
//			}
			
//			System.out.println(year);
		}
	}

	// 유클리드 호제법 최대공약수
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else {
			return gcd(b, a%b);
		}
	}
	
	// 최소공배수
	public static int lcm(int a, int b, int g) {
		return g*(a/g)*(b/g);
	}
}
