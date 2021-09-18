package Programmers;

import java.util.Arrays;
//import java.util.HashMap; 
//import java.util.Map;

/*
 * 2021.09.18 daily algo/commit
 * 
 * 접두사가 존재하는 단어 한개만 찾으면 바로 false로 종료
 * => phone_book 배열을 정렬하면 접두어가 같은 순으로 정렬되기 때문에 바로 다음 단어만 검색하면 구할 수 있다.
 */

public class prg_L2_전화번호목록 {
	
	static String[] phone_book = {"119", "97674223", "1195524421"};

	public static void main(String[] args) {
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) return false;
		}
		return true;
		
		/*
        Map<Integer, String> book = new HashMap<Integer, String>();
        
        for(int i=0; i<phone_book.length; i++) {
        	book.put(i, phone_book[i]); 
        }
        
        for(int i=0; i<book.size()-1; i++) {
    		if(book.get(i+1).startsWith(book.get(i))) return false;
        }
		return true;
		*/
		
		/* 이중 for문으로 전체 탐색 => 시간복잡도 제곱
        
        for(int i=0; i<phone_book.length-1; i++) {
        	for(int j=i+1; j<phone_book.length; j++) {
        		if(phone_book[i].length() <= phone_book[j].length()) {
        			if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
        				return false;
        			}
        		}
        	}
        }
        return true;
        
        */
    }

}
