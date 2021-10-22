package Programmers;

import java.util.Arrays;

/*
 * 2021.10.22 daily algo/commit
 * 
 * 프로그래머스 L1 - 
 * 무조건 앞 학생에게 먼저 빌려주는 것이 최선의 선택이다.
 */

public class prg_L1_체육복 {
	
	static int n = 5; // 전체 학생 수
	static int[] lost = {2,4}; // 도난 체육복
//	static int[] reserve = {1,3,5}; // 여벌 체육복
	static int[] reserve = {3}; // 여벌 체육복

	public static void main(String[] args) {
		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n+1];
        
        // 잃어버린 학생 : -1, 1벌있는 학생 : 0, 2벌있는 학생 : 1
        for(int i=0; i<reserve.length; i++) { // 2벌 있는 학생
        	clothes[reserve[i]] = 1;
        }
        
        for(int i=0; i<lost.length; i++) {
    		clothes[lost[i]] -= 1;
        }
        
        borrowing(clothes);
        for(int i=1; i<clothes.length; i++) {
        	if(clothes[i] != -1) answer += 1;
        }
        return answer;
    }
	
	public static void borrowing(int[] clothes) {
		for(int i=1; i<clothes.length; i++) {
			if(clothes[i] == 1) { // 여분 있는 학생일 때
				if(i-1 > 0) { // 1~n번 학생
					if(clothes[i-1] == -1) { // 앞 학생이 체육복이 없는 학생일 때
						clothes[i] -= 1;
						clothes[i-1] = 0;
						continue;
					}
				}
				if(i+1 < clothes.length) {
					if(clothes[i+1] == -1) { // 뒤 학생이 체육복이 없는 학생일 때
						clothes[i] -= 1;
						clothes[i+1] = 0;
						continue;
					}
				}
				
			}
			
			System.out.println(Arrays.toString(clothes));
		}
	}

}
