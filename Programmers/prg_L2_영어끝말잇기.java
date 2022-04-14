package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 2022.04.14 daily algo/commit
 * 
 * 나머지, 몫 계산은 꼼꼼히!
 */

public class prg_L2_영어끝말잇기 {
	
	static int n = 3;
	static String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(n, words)));
	}

	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> word = new HashMap<String, Integer>();

        word.put(words[0], 1);
        char cur = words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++) {
        	char next = words[i].charAt(0);
        	if(words[i].length() == 1) {
        		fail(i, n, answer);
    			break;
        	}
        	if(cur == next) { // 이어질 때
        		// 나왔던 단어일 때
        		if(word.containsKey(words[i])) {
        			fail(i, n, answer);
        			break;
        		}
        		else {
        			word.put(words[i], 1);
        			cur = words[i].charAt(words[i].length()-1);
        		}
        	}
        	else { // 끝말잇기 안될 때
        		fail(i, n, answer);
    			break;
        	}
        }

        if(words[0].length() == 1) answer[0] = answer[1] = 0;
        return answer;
    }
	
	public static int[] fail(int i, int n, int[] answer) {
		answer[0] = i%n + 1;
		answer[1] = (int) Math.ceil((double) (i+1)/n);
		
        return answer;
	}
}
