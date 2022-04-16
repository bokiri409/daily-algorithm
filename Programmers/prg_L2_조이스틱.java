package Programmers;

import java.util.Arrays;

/*
 * 2021.03.20 daily algo/commit
 * 
 * Greedy
 * 중간의 A..A의 길이가 가장 긴 개수를 찾는다
 * 해당 부분의 길이를 빼고 나머지를 계산해본다.
 */

public class prg_L2_조이스틱 {
	
	static String name = "JEROEN";

	public static void main(String[] args) {
		System.out.println(solution(name));
	}

	public static int solution(String name) {
		// 돌리는 횟수
		int rotate = 0;
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i) != 'A') {
				rotate += Math.min((((int) name.charAt(i)) - 65), (91 - (int) name.charAt(i)));
			}
		}
		
		// 정방향
		int idx_f = 0;
		for(int i=name.length()-1; i>=0; i--) {
			if(name.charAt(i) != 'A') {
				idx_f = i;
				break;
			}
		}
		
		int min = Integer.MAX_VALUE;
		int move = 0;
		for(int i=0; i<idx_f; i++) {
			move += 1;
		}
		min = Math.min(min, move);
		
		// 역방향
		int idx_b = 0;
		for(int i=1; i<name.length(); i++) {
			if(name.charAt(i) != 'A') {
				idx_b = i;
				break;
			}
		}
		move = 0;
		for(int i=name.length()-1; i>=idx_b; i--) {
			move += 1;
		}
		min = Math.min(min, move);
		
		// 다시 되돌아가는 경우 (중간에 존재하는 A를 모두 검사)
		int start, end;
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i) == 'A') {
				start = i;
				for(int j=start+1; j<name.length(); j++) {
					if(name.charAt(j) != 'A') {
						end = j-1;
						move = checkA(start, end, name.length()-1);
						break;
					}
				}
			}
			min = Math.min(min, move);
		}
		
        return rotate+min;
    }
	
	public static int checkA(int start, int end, int l) {
		int move = 0;
		if(start == 0) start = 1;
		// 정방향 후 역방향
		move = (start-1)*2 + (l-end);
		
		// 역방향 후 정방향
		move = Math.min(move, (l-end)*2 + start-1);
		return move;
	}
}
