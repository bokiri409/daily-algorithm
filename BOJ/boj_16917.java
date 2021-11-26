package BOJ;

import java.util.Scanner;

/*
 * 2021.11.26 daily algo/commit
 * 
 */

public class boj_16917 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 후라이드
		int B = sc.nextInt(); // 양념
		int C = sc.nextInt(); // 반반
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int price = 0;
		
		/*
		 * 풀이 1
		if(A+B > C*2) {
			price += C*2*Math.min(X, Y);
			if(X > Y) { // 후라이드가 더 많을 때
				if(C*2 < A) price += C*2*(X-Y);
				else price += (X-Y) * A;
			}
			else {
				if(C*2 < B) price += C*2*(Y-X);
				else price += (Y-X) * B;
			}
		}
		else {
			price += A*X + B*Y;
		}
		
		System.out.println(price);
		*/
		
		// 풀이 2
		int min = Integer.MAX_VALUE;
		int Z = 0;
		for(int i=0; i<=100000; i++) {
			Z = 2 * i;
			price = (Z * C) + Math.max(0, X-Z/2) * A + Math.max(0, Y-Z/2) * B;
			if(min > price) min = price;
		}
		
		System.out.println(min);
		sc.close();
	}

}
