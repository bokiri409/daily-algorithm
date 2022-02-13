package Programmers;

/*
 * 2021.02.13 daily algo/commit
 */

public class prg_L2_문자열압축 {
	
//	static String s = "abcabcabcabcdededededede";
//	static String s = "aabbaccc";
//	static String s = "xababcdcdababcdcd";
	static String s = "a";

	public static void main(String[] args) {
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int min = 1000;
		for(int i=1; i<=s.length()/2; i++) {
			String word = "";
			// 나누어 떨어지지 않아도 다 테스트 해야한다!
//			if(s.length() % i == 0) {
				String str = s.substring(0, i);
				int num = 1;
				for(int j=1; j<s.length() / i; j++) {
					String str_next = s.substring(j*i, j*i + i);
					if(str.equals(str_next)) {
						num += 1;
					}
					else {
						if(num > 1) {
							word += num;
							num = 1;
						}
						word += str;
					}
					str = str_next;
					if(j == s.length() / i - 1) {
						if(num > 1) word += num;
						word += str_next;
						word += s.substring(j*i + i, s.length());
					}
				}
//			}
			min = Math.min(min, word.length());
		}
		// 길이가 1인경우 예외처리
		if(s.length() == 1) min = 1;
        return min;
    }

}
