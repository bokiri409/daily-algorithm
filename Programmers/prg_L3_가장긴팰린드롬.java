package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.02.02 daily algo/commit
 * 
 * DP
 * LCS(Longest Commen Subsequence) : 최장 공통 부분수열
 * 참고블로그 : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
 * 
 */

public class prg_L3_가장긴팰린드롬 {
	public static void main(String[] args) {
//		String s = "abcdcba";
//		String s = "abacde";
		String s = "abcde";
		System.out.println(solution(s));
	}
	
	public static int solution(String s)
    {
		int max = 1; // default값은 0이 아닌 1!
		Queue<Integer> q = new LinkedList<Integer>();
		// 길이가 2
        for(int i=0; i<s.length()-1; i++) {
        	if(s.charAt(i) == s.charAt(i+1)) q.add(i);
        }
        while(!q.isEmpty()) {
        	int max2 = 2;
        	int idx = q.poll();
        	int chk = 1;
        	while(true) {
        		if(idx - chk < 0 || idx + chk + 1 >= s.length()) break;
        		if(s.charAt(idx - chk) == s.charAt(idx + chk + 1)) {
        			max2 += 2;
        			chk += 1;
        		}
        		else break;
        	}
        	max = Math.max(max2, max);
        }
        
        // 길이가 3
        for(int i=0; i<s.length()-2; i++) {
        	if(s.charAt(i) == s.charAt(i+2)) q.add(i);
        }
        while(!q.isEmpty()) {
        	int max3 = 3;
        	int idx = q.poll();
        	int chk = 1;
        	while(true) {
        		if(idx - chk < 0 || idx + chk + 2 >= s.length()) break;
        		if(s.charAt(idx - chk) == s.charAt(idx + chk + 2)) {
        			max3 += 2;
        			chk += 1;
        		}
        		else break;
        	}
        	max = Math.max(max3, max);
        }
        
        return max;
    }
}
