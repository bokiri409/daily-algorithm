package Programmers;

import java.util.Arrays;

/*
 * 2021.10.11 daily algo/commit
 */

public class prg_L2_ī�� {
	
	static int brown = 24;
	static int yellow = 24;
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // ī���� ���δ� ������ ���̺��� ���ų� ���.
        int xySum = (brown + 4) / 2; // (���� + ����) ����
        
        int i = 0;
        do {
        	x = 3 + i; // ���� ���� 3���� ����
        	y = xySum - x; // ����
        	
        	if((x-2)*(y-2) == yellow) break;
        	i += 1;
        }while(x <= y);
        
        answer[0] = y;
        answer[1] = x;
        return answer;
    }

}
