package Programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 2021.09.24 daily algo/commit
 * 
 * 프로그래머스 - 해시
 * 의상(키)별로 개수 확인 후 곱해주기
 * (의상개수1+1)*(의상개수2+1)... -1
 * +1 : 의상개수에 안입는 경우, -1 : 전체 아무것도 안입는 경우 1가지(최소 하나 이상의 입어야 함)
 */

public class prg_L2_위장 {
	
	// 1~30개
	static String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

	public static void main(String[] args) {
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        Map<String, ArrayList<String>> clothing = new HashMap<String, ArrayList<String>>();
        ArrayList<String> details;
        
        for(int i=0; i<clothes.length; i++) {
        	if(clothing.containsKey(clothes[i][1])) { // 맵에 존재하는 키라면
        		clothing.get(clothes[i][1]).add(clothes[i][0]);
        	}
        	else {
        		details = new ArrayList<String>(); // 새로운 List 생성
        		details.add(clothes[i][0]);
        		clothing.put(clothes[i][1], details);
        	}
        }
        
//        Set<String> keys = clothing.keySet(); // 맵의 키 집합 
        Collection<ArrayList<String>> values = clothing.values(); // 맵의 value집합
        Iterator<ArrayList<String>> iter = values.iterator();
        int answer = 1;
        while(iter.hasNext()) {
        	int value = iter.next().size();
        	answer *= value+1;
        }
        
        return answer-1;
    }

}
