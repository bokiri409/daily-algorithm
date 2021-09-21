package Programmers;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * 2021.09.21 daily algo/commit
 * 
 * numbers ���Ұ� 1000�����̹Ƿ� string���� ��ȯ�ؼ� ������ �� �������� *3�踦 ���ָ� �ȴ�.
 * ex) 998�� 9�� 9�� ���� ���ĵǴ� 9.998�� 998.9���� �� ū ���� �ȴ�.
 * 		���� ���ڿ� 3�踦 ���ָ� 998998998 < 999�� �� ũ�� �Ǳ� ������ 3�踦 �ϰ� �����ָ� �ȴ�.
 * 
 * ���� : https://yurimkoo.github.io/algorithm/2020/06/07/greatest-number.html
 */

public class prg_L2_����ū�� {
	
	static int[] numbers = {3, 30, 34, 5, 9};
	
	public static void main(String[] args) {
		System.out.println(solution(numbers));
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0; i<numbers.length; i++) {
        	String str = "";
        	for(int j=0; j<3; j++) {
        		str += String.valueOf(numbers[i]);
        	}
    		list.add(str); // int�� String���� ����ȯ
        }
        
//        Arrays.sort(list, Collections.reverseOrder()); // ��������
        list.sort(Comparator.reverseOrder()); // ��������
        System.out.println(list);
        
        for(String num : list) {
        	answer += num.substring(0, num.length()/3);
        }
        if(answer.charAt(0) == '0') answer = "0"; // ��� ���Ұ� 0�� ���� 0���� ����
        
        return answer;
    }

}
