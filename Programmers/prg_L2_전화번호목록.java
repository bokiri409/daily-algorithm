package Programmers;

import java.util.Arrays;
//import java.util.HashMap; 
//import java.util.Map;

/*
 * 2021.09.18 daily algo/commit
 * 
 * ���λ簡 �����ϴ� �ܾ� �Ѱ��� ã���� �ٷ� false�� ����
 * => phone_book �迭�� �����ϸ� ���ξ ���� ������ ���ĵǱ� ������ �ٷ� ���� �ܾ �˻��ϸ� ���� �� �ִ�.
 */

public class prg_L2_��ȭ��ȣ��� {
	
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
		
		/* ���� for������ ��ü Ž�� => �ð����⵵ ����
        
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
