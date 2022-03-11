package Programmers;

import java.util.Stack;

/*
 * 2021.03.11 daily algo/commit
 * 
 * substring은 문자열 일부를 잘라내는 함수인데, 
 * 이 작업을 하기 위해서는 새로운 메모리 공간을 할당하고 이 공간에 문자열을 옮겨야 한다.
 * 이때 메모리 할당 혹은 함수 호출 횟수에 의해 시간초과가 난다.
 * 
 * 스택을 이용하면 쉽게 풀 수 있다.
 * 예외 케이스를 잘 생각해서 로직을 작성해야 한다.
 */

public class prg_L2_짝지어제거하기 {
	
//	static String s = "baabaa";
	static String s = "aaaaa";

	public static void main(String[] args) {
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		// substring을 이용한 풀이방식 - 시간초과
		/*
		int idx = 0;
		while(idx < s.length() - 1) {
			if(s.charAt(idx) == s.charAt(idx+1)) {
				s = s.replace(s.substring(idx, idx+2), "");
				if(idx > 0) idx -= 1;
			}
			else idx += 1; 
			if(s.length() == 0) break;
//			if(idx == s.length() - 2) break;
		}
		
        if(s.length() > 0) return 0;
        return 1;
        */
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		
		int idx = 1;
		while(idx < s.length()) {
			if(st.isEmpty()) {
				st.push(idx);
				idx += 1;
				if(idx >= s.length()) break;
			}
			if(s.charAt(idx) == s.charAt(st.peek())) st.pop();
			else st.push(idx);
			idx += 1;
		}
		
		if(st.isEmpty()) return 1;
		return 0;
    }

}
