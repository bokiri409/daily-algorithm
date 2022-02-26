package Programmers;

/*
 * 2022.02.26 daily algo/commit
 * 
 * 문제 자체를 이해하는데 오래걸렸다.
 * 꼼꼼히 문제를 읽자!
 * 
 * u, v로 문자열을 분리하고 
 * ( + v(올바른 문자열 체크 수행) + ) + u의 첫번째, 마지막 문자 제거 후 안에 문자는 괄호 방향 바꿔서 붙이기
 */

public class prg_L2_괄호변환 {
	
//	static String p = "(()())()";
//	static String p = ")()(";
//	static String p = "()))((()";
	static String p = ")()(()";

	public static void main(String[] args) {
		System.out.println(solution(p));
	}
	
	public static String solution(String p) {
        if(check(p)) return p;
        return separate(p);
    }
	
	// 균형잡힌 문자열 분리
	public static String separate(String str) {
		if(str.length() == 0) return "";
		String u = "";
		String v = "";
		
		int chk = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				chk += 1;
				u += '(';
			}
			else {
				chk -= 1;
				u += ')';
			}
			
			if(chk == 0) {
				v = str.substring(i+1);
				break;
			}
		}
		
		if(check(u)) {
			return u + separate(v);
		}
		else {
			String s = "(" + separate(v);
			s += ")";
			for(int i=1; i<u.length()-1; i++) {
				if(u.charAt(i) == '(') s += ')';
				else s += '(';
			}
			return s;
		}
	}
	
	// 올바른 문자열인지 확인
	public static boolean check(String str) {
		if(str.length() == 0) return false;
		if(str.charAt(0) == ')') return false;
		
		int chk = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') chk += 1;
			else chk -= 1;
			
			if(chk < 0) return false;
		}
		return true;
	}

}
