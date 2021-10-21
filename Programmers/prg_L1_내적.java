package Programmers;

/*
 * 2021.10.21 daily algo/commit
 * 
 * 프로그래머스 월간 코드 챌린지 시즌1
 */

public class prg_L1_내적 {
	
	static int[] a = {1,2,3,4};
	static int[] b = {-3,-1,0,2};

	public static void main(String[] args) {
		System.out.println(solution(a, b));
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
        	answer += a[i] * b[i];
        }
        
        return answer;
    }

}
