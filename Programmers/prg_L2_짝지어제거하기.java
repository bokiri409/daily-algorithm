package Programmers;

import java.util.Stack;

/*
 * 2021.03.11 daily algo/commit
 * 
 * substring�� ���ڿ� �Ϻθ� �߶󳻴� �Լ��ε�, 
 * �� �۾��� �ϱ� ���ؼ��� ���ο� �޸� ������ �Ҵ��ϰ� �� ������ ���ڿ��� �Űܾ� �Ѵ�.
 * �̶� �޸� �Ҵ� Ȥ�� �Լ� ȣ�� Ƚ���� ���� �ð��ʰ��� ����.
 * 
 * ������ �̿��ϸ� ���� Ǯ �� �ִ�.
 * ���� ���̽��� �� �����ؼ� ������ �ۼ��ؾ� �Ѵ�.
 */

public class prg_L2_¦���������ϱ� {
	
//	static String s = "baabaa";
	static String s = "aaaaa";

	public static void main(String[] args) {
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		// substring�� �̿��� Ǯ�̹�� - �ð��ʰ�
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
