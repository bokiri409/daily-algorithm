package BOJ;

import java.util.Scanner;

/*
 * 2022.05.12 daily algo/commit
 * 
 * Brute Force
 */

public class boj_1107 {
	
	static final int channel = 100;
	static boolean[] buttons = new boolean[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 이동하려는 채널
		int broken_buttons = sc.nextInt(); // 고장난 버튼 수
		for(int i=0; i<broken_buttons; i++) {
			buttons[sc.nextInt()] = true;
		}
		sc.close();
		
		int min = Integer.MAX_VALUE; // 최소값
		// 1. 버튼 누르지 않는 경우
		min = Math.abs(N - channel);
		
		int len = 1; // 자리수
		for(int i=0; i<=1000000; i++) {
			if(check(i)) { // 이동 가능하면
				if(i >= 10) len = (int) (Math.log10(i)+1);
				min = Math.min(min, Math.abs(i-N)+len);
			}
		}
		System.out.println(min);
	}

	// 이동 가능한 채널인지 확인
	public static boolean check(int c) {
		// c가 0일 때는 예외케이스로 빼준다.
		if(c == 0) {
			if(buttons[c]) return false;
			else return true;
		}
		
		while(c > 0) {
			if(buttons[c % 10]) return false;
			c /= 10;
		}
		return true;
	}
}
