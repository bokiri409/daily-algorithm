package Programmers;

import java.util.HashMap;
import java.util.Map;

/*
 * 2022.04.17 daily algo/commit
 * 
 * 예외 케이스를 잘 처리해야됨.
 * - 두 집합 모두 공집합인 경우
 */

public class prg_L2_뉴스클러스터링 {
	
	static String str1 = "A+C";
	static String str2 = "DEF";

	public static void main(String[] args) {
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		
		set(str1, map1);
		set(str2, map2);
		
		Map<String, Integer> map;
		if(map1.size() <= map2.size()) {
			map = map1;
			map1 = map2;
			map2 = map;
		}
		
		int cnt = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		for(String key : map2.keySet()) {
			cnt2 += map2.get(key);
			if(map1.containsKey(key)) cnt += Math.min(map1.get(key), map2.get(key));
		}
		for(String key : map1.keySet()) {
			cnt1 += map1.get(key);
		}
		
        int union = (cnt1-cnt) + cnt2;
        int answer = (int) (((double) cnt/union)*65536);
        if(cnt1 == 0 && cnt2 == 0) answer = 65536;
        return answer;
    }
	
	public static void set(String str, Map<String, Integer> map) {
		for(int i=0; i<str.length()-1; i++) {
			String s = str.substring(i, i+2);
			if(s.charAt(0)-0 <= 122 && s.charAt(0)-0 >= 97 && s.charAt(1)-0 <= 122 && s.charAt(1)-0 >= 97) {
				map.put(s, map.getOrDefault(s, 0)+1);
			}
		}
	}
}
