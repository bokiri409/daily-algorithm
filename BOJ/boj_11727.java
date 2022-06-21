package BOJ;

import java.util.Scanner;

/*
 * 2022.06.21 daily algorithm
 * 
 * DP - 큰 문제를 작은 문제로 해결한다.
 * 1. 1x2 타일 : D[n-1]
 * 2. 2x1 타일 : D[n-2]
 * 3. 2x2 타일 : D[n-2]
 * => D[n] = D[n-1] + D[n-2] * 2
 * 
 * !! n=1 일때 런타임 에러를 조심하자. (배열의 크기 조심)
 */

public class boj_11727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		int[] D = new int[n+2];
		D[1] = 1; D[2] = 3;
		for(int i=3; i<=n; i++) {
			D[i] = (D[i-1] + D[i-2]*2) % 10007;
		}
		
		System.out.println(D[n]);
	}

}
