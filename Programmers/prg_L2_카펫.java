package Programmers;

import java.util.Arrays;

/*
 * 2021.10.11 daily algo/commit
 */

public class prg_L2_카펫 {
	
	static int brown = 24;
	static int yellow = 24;
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 카펫의 가로는 세로의 길이보다 같거나 길다.
        int xySum = (brown + 4) / 2; // (가로 + 세로) 길이
        
        int i = 0;
        do {
        	x = 3 + i; // 세로 최저 3부터 시작
        	y = xySum - x; // 가로
        	
        	if((x-2)*(y-2) == yellow) break;
        	i += 1;
        }while(x <= y);
        
        answer[0] = y;
        answer[1] = x;
        return answer;
    }

}
