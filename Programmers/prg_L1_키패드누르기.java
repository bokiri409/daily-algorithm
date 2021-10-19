package Programmers;

import java.util.Arrays;

/*
 * 2021.10.19 daily algo/commit
 * 
 * ���α׷��ӽ� 2020 īī�� ���Ͻ� ����
 * 
 * keypad�� �迭�� ���� ������ �ε����� 3���� ���� ��, �������� �̿��Ͽ� �ش� ��, �� index���� ���Ѵ�.
 * 0�� 11�� ��ȯ�ؼ� �����Ѵ�.
 */

public class prg_L1_Ű�е崩���� {
	
	static int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
	static String hand = "left";
	
	static int lefthand = 10; // ���� �޼� ��ġ
    static int righthand = 12; // ���� ������ ��ġ
    static Integer[] keypad = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // Ű�е�

	public static void main(String[] args) {
		System.out.println(solution(numbers, hand));
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int leftdist = 0;
        int rightdist = 0;
        int idx = 0;
        int x = 0; // ��
        int y = 0; // ��
        
        for(int i=0; i<numbers.length; i++){
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) { // ���� ��
        		lefthand = numbers[i];
        		answer += "L";
        	}
        	else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
        		if(numbers[i] == 0) {
            		numbers[i] += 11;
            	}
        		idx = Arrays.asList(keypad).indexOf(numbers[i]);
        		// ���� ���� Ű�е��� ��ġ
        		x = idx / 3;
        		y = idx % 3;
        		
        		leftdist = Math.abs(x-((lefthand-1) / 3)) + Math.abs(y-((lefthand-1) % 3));
        		rightdist = Math.abs(x-((righthand-1) / 3)) + Math.abs(y-((righthand-1) % 3));
        		if(leftdist < rightdist) { // �޼��� �� ����� ��
        			lefthand = numbers[i];
        			answer += "L";
        		}
        		else if(leftdist > rightdist) { // �������� �� ����� ��
        			righthand = numbers[i];
        			answer += "R";
        		}
        		else { // �Ÿ��� ���� ��
        			if(hand.equals("left")) {
        				lefthand = numbers[i];
        				answer += "L";
        			}
        			else {
        				righthand = numbers[i];
        				answer += "R";
        			}
        		}
        	}
        	else { // ������ ��
        		righthand = numbers[i];
        		answer += "R";
        	}
        }
        return answer;
    }

}
