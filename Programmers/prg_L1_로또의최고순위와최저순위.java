package Programmers;

import java.util.stream.IntStream;

/*
 * 2021.09.15 daily algo/commit
 * 
 * �ڹ� 7���ϴ� Arrays.asList(arr).contains("����, ���ڿ�");
 * �ڹ� 8�̻��� intStream ���!!
 */

public class prg_L1_�ζ����ְ�������������� {
	
	static int[] lottos = {44,1,0,0,31,25};
//	static int[] lottos = {0, 0, 0, 0, 0, 0};
//	static int[] lottos = {45, 4, 35, 20, 3, 9};
	static int[] win_nums = {31,10,45,1,6,19};
//	static int[] win_nums = {38, 19, 20, 40, 15, 25};
//	static int[] win_nums = {20, 9, 3, 45, 4, 35};

	public static void main(String[] args) {
		for(int i=0; i<2; i++) {
			System.out.println(solution(lottos, win_nums)[i]);
		}
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int correct = 0;
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i] == 0) { // 0�� ���
        		cnt += 1;
        	}
        	else {
        		int num = lottos[i];
        		if(IntStream.of(win_nums).anyMatch(x -> x == num)) { // ��÷ ��ȣ�� �ִٸ�
        			correct += 1;
        		}
        	}
        }
        answer[1] = correct;
        answer[0] = correct+cnt;
//        System.out.println(correct+" "+cnt);
        
        for(int i=0; i<2; i++) {
        	switch (answer[i]) {
        	case 6:
        		answer[i] = 1;
        		break;
        	case 5:
        		answer[i] = 2;
        		break;
        	case 4:
        		answer[i] = 3;
        		break;
        	case 3:
        		answer[i] = 4;
        		break;
        	case 2:
        		answer[i] = 5;
        		break;
        	default: //0,1 ��÷�� ��
        		answer[i] = 6;
        		break;
        	}
        }
        
        return answer;
    }

}
