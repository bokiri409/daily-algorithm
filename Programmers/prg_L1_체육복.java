package Programmers;

import java.util.Arrays;

/*
 * 2021.10.22 daily algo/commit
 * 
 * ���α׷��ӽ� L1 - 
 * ������ �� �л����� ���� �����ִ� ���� �ּ��� �����̴�.
 */

public class prg_L1_ü���� {
	
	static int n = 5; // ��ü �л� ��
	static int[] lost = {2,4}; // ���� ü����
//	static int[] reserve = {1,3,5}; // ���� ü����
	static int[] reserve = {3}; // ���� ü����

	public static void main(String[] args) {
		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n+1];
        
        // �Ҿ���� �л� : -1, 1���ִ� �л� : 0, 2���ִ� �л� : 1
        for(int i=0; i<reserve.length; i++) { // 2�� �ִ� �л�
        	clothes[reserve[i]] = 1;
        }
        
        for(int i=0; i<lost.length; i++) {
    		clothes[lost[i]] -= 1;
        }
        
        borrowing(clothes);
        for(int i=1; i<clothes.length; i++) {
        	if(clothes[i] != -1) answer += 1;
        }
        return answer;
    }
	
	public static void borrowing(int[] clothes) {
		for(int i=1; i<clothes.length; i++) {
			if(clothes[i] == 1) { // ���� �ִ� �л��� ��
				if(i-1 > 0) { // 1~n�� �л�
					if(clothes[i-1] == -1) { // �� �л��� ü������ ���� �л��� ��
						clothes[i] -= 1;
						clothes[i-1] = 0;
						continue;
					}
				}
				if(i+1 < clothes.length) {
					if(clothes[i+1] == -1) { // �� �л��� ü������ ���� �л��� ��
						clothes[i] -= 1;
						clothes[i+1] = 0;
						continue;
					}
				}
				
			}
			
			System.out.println(Arrays.toString(clothes));
		}
	}

}
