package Programmers;

import java.util.Arrays;

/*
 * 2021.10.28 daily algo/commit
 * 
 * 프로그래머스 커뮤러닝 1주차-A 시뮬레이션
 */


public class prg_1A_시뮬레이션 {
	
//	static int[] A = {5,1,3,7};
//	static int[] B = {2,2,6,8};
	static int[] A = {2,2,2,2};
	static int[] B = {1,1,1,1};

	public static void main(String[] args) {
		System.out.println(solution(A, B));
	}
	
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        for(int i=0; i<B.length; i++) {
        	if(B[i] > A[a]) { //B의 점수가 크면
        		answer += 1;
        		a += 1;
        		continue;
        	}
        }
        
        return answer;
    }

}
