package Programmers;

import java.util.stream.IntStream;

/*
 * 2021.09.15 daily algo/commit
 * 
 * 자바 7이하는 Arrays.asList(arr).contains("숫자, 문자열");
 * 자바 8이상은 intStream 사용!!
 */

public class prg_L1_로또의최고순위와최저순위 {
	
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
        	if(lottos[i] == 0) { // 0인 경우
        		cnt += 1;
        	}
        	else {
        		int num = lottos[i];
        		if(IntStream.of(win_nums).anyMatch(x -> x == num)) { // 당첨 번호가 있다면
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
        	default: //0,1 낙첨일 때
        		answer[i] = 6;
        		break;
        	}
        }
        
        return answer;
    }

}
