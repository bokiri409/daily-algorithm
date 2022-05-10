package BOJ;

import java.util.Scanner;

/*
 * 2022.05.10 daily algo/commit
 */

public class boj_2609_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int g = gcd(a, b);
//		int g = gcd2(a, b);
		int l = lcm(a, b, g);
		System.out.println(g+"\n"+l);
	}

	// ��Ŭ���� ȣ���� : gcd(a, b) == gcd(b, r(=a%b))
	// 1. ����Լ��� �̿��� ��Ŭ���� ȣ����
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else {
			return gcd(b, a%b);
		}
	}
	
	// 2. �ݺ����� �̿��� ��Ŭ���� ȣ����
	public static int gcd2(int a, int b) {
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	// �ּҰ����
	public static int lcm(int a, int b, int g) {
		return g*(a/g)*(b/g);
	}
}
