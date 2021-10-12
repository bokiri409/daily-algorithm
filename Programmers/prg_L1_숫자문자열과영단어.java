package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.10.12 daily algo/commit
 * 
 * 2021 카카오 채용연계 인턴쉽 기출
 */

public class prg_L1_숫자문자열과영단어 {
	
	static String s = "one4seveneight";

	public static void main(String[] args) {
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        String answer = "";
        Queue<Character> q = new LinkedList<Character>();
        for(int i=0; i<s.length(); i++) {
        	q.add(s.charAt(i));
        }
        
        String word = "";
        while(!q.isEmpty()) {
        	word += q.poll();
        	String result = check(word);
        	if(result.length() != 0) { // 리턴값이 있다면
        		answer += result;
        		word = ""; // word값 초기화
        	}
        }
        return Integer.parseInt(answer);
    }
	
	public static String check(String word) {
		String num = "";
		switch (word) {
		case "zero":
		case "0":
			num = "0";
			break;
		case "one":
		case "1":
			num = "1";
			break;
		case "two":
		case "2":
			num = "2";
			break;
		case "three":
		case "3":
			num = "3";
			break;
		case "four":
		case "4":
			num = "4";
			break;
		case "five":
		case "5":
			num = "5";
			break;
		case "six":
		case "6":
			num = "6";
			break;
		case "seven":
		case "7":
			num = "7";
			break;
		case "eight":
		case "8":
			num = "8";
			break;
		case "nine":
		case "9":
			num = "9";
			break;
		default:
			return "";
		}
		return num;
	}

}
