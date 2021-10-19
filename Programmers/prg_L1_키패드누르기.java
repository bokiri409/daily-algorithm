package Programmers;

import java.util.Arrays;

/*
 * 2021.10.19 daily algo/commit
 * 
 * 프로그래머스 2020 카카오 인턴쉽 기출
 * 
 * keypad의 배열을 만들어서 각각의 인덱스를 3으로 나눈 몫, 나머지를 이용하여 해당 행, 열 index값을 구한다.
 * 0은 11로 변환해서 구현한다.
 */

public class prg_L1_키패드누르기 {
	
	static int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
	static String hand = "left";
	
	static int lefthand = 10; // 현재 왼손 위치
    static int righthand = 12; // 현재 오른손 위치
    static Integer[] keypad = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // 키패드

	public static void main(String[] args) {
		System.out.println(solution(numbers, hand));
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int leftdist = 0;
        int rightdist = 0;
        int idx = 0;
        int x = 0; // 행
        int y = 0; // 열
        
        for(int i=0; i<numbers.length; i++){
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) { // 왼쪽 줄
        		lefthand = numbers[i];
        		answer += "L";
        	}
        	else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
        		if(numbers[i] == 0) {
            		numbers[i] += 11;
            	}
        		idx = Arrays.asList(keypad).indexOf(numbers[i]);
        		// 다음 누를 키패드의 위치
        		x = idx / 3;
        		y = idx % 3;
        		
        		leftdist = Math.abs(x-((lefthand-1) / 3)) + Math.abs(y-((lefthand-1) % 3));
        		rightdist = Math.abs(x-((righthand-1) / 3)) + Math.abs(y-((righthand-1) % 3));
        		if(leftdist < rightdist) { // 왼손이 더 가까울 때
        			lefthand = numbers[i];
        			answer += "L";
        		}
        		else if(leftdist > rightdist) { // 오른손이 더 가까울 때
        			righthand = numbers[i];
        			answer += "R";
        		}
        		else { // 거리가 같을 때
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
        	else { // 오른쪽 줄
        		righthand = numbers[i];
        		answer += "R";
        	}
        }
        return answer;
    }

}
