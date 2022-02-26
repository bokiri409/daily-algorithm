package Programmers;

/*
 * 2022.02.26 daily algo/commit
 * 
 * ���� ��ü�� �����ϴµ� �����ɷȴ�.
 * �Ĳ��� ������ ����!
 * 
 * u, v�� ���ڿ��� �и��ϰ� 
 * ( + v(�ùٸ� ���ڿ� üũ ����) + ) + u�� ù��°, ������ ���� ���� �� �ȿ� ���ڴ� ��ȣ ���� �ٲ㼭 ���̱�
 */

public class prg_L2_��ȣ��ȯ {
	
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
	
	// �������� ���ڿ� �и�
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
	
	// �ùٸ� ���ڿ����� Ȯ��
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
