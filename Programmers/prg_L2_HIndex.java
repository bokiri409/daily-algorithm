package Programmers;

import java.util.Arrays;

/*
 * 2021.09.23 daily algo/commit
 */

public class prg_L2_HIndex {

	static int[] citations = {3, 0, 6, 1, 5};
	
	public static void main(String[] args) {
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
//        System.out.println(Arrays.toString(citations));
        for(int i=0; i<citations.length; i++) {
        	if(citations[i] >= citations.length - i) { // h값의 최대값 갱신
        		answer = citations.length - i;
        		break;
        	}
        }
        
        return answer;
    }

}
