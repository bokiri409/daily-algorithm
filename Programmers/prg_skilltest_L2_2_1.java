package Programmers;

import java.util.Arrays;

public class prg_skilltest_L2_2_1 {
	
	static int brown = 10;
	static int yellow = 2;
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}
	
	public static int[] solution(int brown, int yellow) {
        int standard = brown / 2 + 2;
        int y = standard / 2; // 세로
        int x = standard - y; // 가로
        
        while(true) {
        	if((x-2)*(y-2) == yellow) break;
        	y -= 1;
        	x += 1;
        }
		int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}