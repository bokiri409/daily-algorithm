package Programmers;

/*
 * 2021.11.01 daily algo/commit
 * 
 * 이중 해쉬맵이 아닌 좀 더 간결한 코드
 */

import java.util.HashMap;

public class prg_L2_위장_2 {
	
	static String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

	public static void main(String[] args) {
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(clothes[0][1], 1);
        for(int i=1; i<clothes.length; i++){
        	String type = clothes[i][1];
            if(map.get(type) == null) { // 해당 옷의 종류가 없을 때
            	map.put(type, 1);
            }
            else {
            	int num = map.get(type);
            	map.put(type, num+1); // 개수 추가
            }
        }
        
        // forEach(람다방식)는 코드라인이 줄고 가독성이 올라가지만 for문의 속도가 느리고 외부 변수들을 참조하기가 힘들어진다는 단점이 있다.
//        map.forEach((key, value) -> {
//        	answer *= (value + 1);
//        });
        
        // 총 옷의 조합 : 옷의 개수 + 안입는 경우(1)
        for(int value : map.values()) {
        	answer *= (value+1);
        }
        
        // 맨몸인 경우(1)를 빼준다.
        return answer - 1;
    }

}
