package BOJ;

import java.util.Scanner;

/*
 * 2022.06.20 daily algorithm
 * 
 * 비트마스크 풀이 
 * M : 300백만 개
 * x : 1~20 => 0~19로 변경해서 풀이
 */

public class boj_11723_bitmask {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int S = 0; // 집합 S에 존재하는 모든 원소의 합
		for(int i=0; i<M; i++) {
			String cal = sc.next();
			if(cal.equals("add") || cal.equals("remove") || cal.equals("check") || cal.equals("toggle")) {
				int n = sc.nextInt() - 1;
				if(cal.equals("add")) {
					S |= (1 << n);
				}
				else if(cal.equals("remove")) {
					S &= ~(1 << n);
				}
				else if(cal.equals("toggle")) {
					S ^= (1 << n);
				}
				else {
					if((S & (1 << n)) == 0) sb.append(0 + "\n");
					else sb.append(1 + "\n");
				}
			}
			// 추가
			else if(cal.equals("all")) {
				for(int j=0; j<20; j++) {
					S |= (1 << j);
				}
			}
			else {
				S = 0;
			}
		}
		sc.close();
		System.out.println(sb);
	}

}
