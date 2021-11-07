package Programmers;

/*
 * 2021.11.07 daily algo/commit
 */

public class prg_L2_¿Ã¹Ù¸¥°ýÈ£ {
	
//	static String s = "()()";
//	static String s = ")()(";
	static String s = "(()(";

	public static void main(String[] args) {
		System.out.println(solution(s));
	}
	
	public static boolean solution(String s) {
        int left = 0; // ¿Þ°ýÈ£
        
        for(int i=0; i<s.length(); i++){
            if(i==0 && s.charAt(0) == ')') return false;
            
            if(s.charAt(i) == '(') {
            	left += 1;
            	continue;
            }
            if(s.charAt(i) == ')') {
            	if(left <= 0) return false;
            	else left -= 1;
            }
        }
        if(left > 0) return false;

        return true;
    }

}
