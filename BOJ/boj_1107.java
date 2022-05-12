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
		
		int N = sc.nextInt(); // �̵��Ϸ��� ä��
		int broken_buttons = sc.nextInt(); // ���峭 ��ư ��
		for(int i=0; i<broken_buttons; i++) {
			buttons[sc.nextInt()] = true;
		}
		sc.close();
		
		int min = Integer.MAX_VALUE; // �ּҰ�
		// 1. ��ư ������ �ʴ� ���
		min = Math.abs(N - channel);
		
		int len = 1; // �ڸ���
		for(int i=0; i<=1000000; i++) {
			if(check(i)) { // �̵� �����ϸ�
				if(i >= 10) len = (int) (Math.log10(i)+1);
				min = Math.min(min, Math.abs(i-N)+len);
			}
		}
		System.out.println(min);
	}

	// �̵� ������ ä������ Ȯ��
	public static boolean check(int c) {
		// c�� 0�� ���� �������̽��� ���ش�.
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
