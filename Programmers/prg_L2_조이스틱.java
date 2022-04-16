package Programmers;

import java.util.Arrays;

/*
 * 2021.03.20 daily algo/commit
 * 
 * Greedy
 * �߰��� A..A�� ���̰� ���� �� ������ ã�´�
 * �ش� �κ��� ���̸� ���� �������� ����غ���.
 */

public class prg_L2_���̽�ƽ {
	
	static String name = "JEROEN";

	public static void main(String[] args) {
		System.out.println(solution(name));
	}

	public static int solution(String name) {
		// ������ Ƚ��
		int rotate = 0;
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i) != 'A') {
				rotate += Math.min((((int) name.charAt(i)) - 65), (91 - (int) name.charAt(i)));
			}
		}
		
		// ������
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
		
		// ������
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
		
		// �ٽ� �ǵ��ư��� ��� (�߰��� �����ϴ� A�� ��� �˻�)
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
		// ������ �� ������
		move = (start-1)*2 + (l-end);
		
		// ������ �� ������
		move = Math.min(move, (l-end)*2 + start-1);
		return move;
	}
}
