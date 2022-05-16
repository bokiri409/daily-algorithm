package BOJ;

import java.util.Scanner;

/*
 * 2022.05.16 daily algo/commit
 * 
 * Brute Force 
 * ��� ��쿡 -1�� �ϰ� �������� ��Ģ�� ���ϸ� �� ����.
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
			// n�Ǵ� m�� �������� ����� �˻��Ѵ�.
			for(int k=0; ; k++) {
				year = k * m + x;
				if(year > l) break;
				if(year % n == y || (year % n == 0 && n == y)) {
					answer = year;
					break;
				}
			}
			System.out.println(answer);
			
			// ���� �� �˻��ϸ� �ð��ʰ�
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

	// ��Ŭ���� ȣ���� �ִ�����
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else {
			return gcd(b, a%b);
		}
	}
	
	// �ּҰ����
	public static int lcm(int a, int b, int g) {
		return g*(a/g)*(b/g);
	}
}
