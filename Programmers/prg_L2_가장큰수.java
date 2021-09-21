package Programmers;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * 2021.09.21 daily algo/commit
 * 
 * numbers 원소가 1000까지이므로 string으로 변환해서 정렬할 수 있으려면 *3배를 해주면 된다.
 * ex) 998와 9는 9가 먼저 정렬되는 9.998이 998.9보다 더 큰 수가 된다.
 * 		따라서 문자열 3배를 해주면 998998998 < 999가 더 크게 되기 때문에 3배를 하고 비교해주면 된다.
 * 
 * 참고 : https://yurimkoo.github.io/algorithm/2020/06/07/greatest-number.html
 */

public class prg_L2_가장큰수 {
	
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
    		list.add(str); // int를 String으로 형변환
        }
        
//        Arrays.sort(list, Collections.reverseOrder()); // 내림차순
        list.sort(Comparator.reverseOrder()); // 내림차순
        System.out.println(list);
        
        for(String num : list) {
        	answer += num.substring(0, num.length()/3);
        }
        if(answer.charAt(0) == '0') answer = "0"; // 모두 원소가 0일 때는 0으로 리턴
        
        return answer;
    }

}
