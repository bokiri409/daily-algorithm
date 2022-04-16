package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 2021.03.09 daily algo/commit
 * 
 * 조합을 등장한 모든 알파벳의 조합이 아닌 각각의 주문에 대한 조합을 만들 것. => 시간초과의 원인이 된다.
 */

public class prg_L2_메뉴리뉴얼 {
	
//	static String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
	static String[] orders = {"XYZ", "XWY", "WXA"};
	static int[] course = {2,3,4};

	public static void main(String[] args) {
		System.out.println(solution(orders, course));
	}

	public static ArrayList<String> solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0; i<course.length; i++) {
			int[] set = new int[course[i]];
			Map<ArrayList<Character>, Integer> count = new HashMap<ArrayList<Character>, Integer>();
			
			for(int j=0; j<orders.length; j++) {
				char[] menu = new char[orders[j].length()];
				for(int k=0; k<orders[j].length(); k++) {
					menu[k] = orders[j].charAt(k);
				}
				Arrays.sort(menu);
				
				boolean[] visited = new boolean[menu.length];
				combination(course[i], menu.length, 0, menu, set, visited, orders, count);
				// 가장 많은 횟수로 정렬
			}
			List<Entry<ArrayList<Character>, Integer>> list = new ArrayList<Entry<ArrayList<Character>,Integer>>(count.entrySet());
			Collections.sort(list, new Comparator<Entry<ArrayList<Character>, Integer>>() {
				public int compare(Entry<ArrayList<Character>, Integer> o1, Entry<ArrayList<Character>, Integer> o2) {
					// 오름 차순 정렬
					return o2.getValue().compareTo(o1.getValue());
				}
			});
//			System.out.println("@@"+list);
			
			int first = 0;
			if(list.size() > 0) {
				first = list.get(0).getValue(); // 첫번째 value값
			}
			for(Entry<ArrayList<Character>, Integer> entry : list) {
				String s = "";
				if(first == entry.getValue()) {
					for(int k=0; k<entry.getKey().size(); k++) {
						s += entry.getKey().get(k);
					}
					if(!answer.contains(s)) {
						
						answer.add(s);
					}
					first = entry.getValue();
				}
				else break;
			}
		}
		Collections.sort(answer);
        return answer;
    }
	
	public static void combination(int r, int n, int start, char[] menu, int[] set, boolean[] visited, String[] orders, Map<ArrayList<Character>, Integer> count) {
		if(r == 0) {
			check(menu, set, orders, count);
			return;
		}
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				set[set.length-r] = i;
				combination(r-1, n, i+1, menu, set, visited, orders, count);
				visited[i] = false;
			}
		}
	}
	
	public static void check(char[] menu, int[] set, String[] orders, Map<ArrayList<Character>, Integer> count) {
		int cnt = 0;
		for(int i=0; i<orders.length; i++) {
			int idx = 0;
			for(int j=0; j<set.length; j++) {
				for(int k=0; k<orders[i].length(); k++) {
					if(orders[i].charAt(k) == menu[set[j]]) {
						idx += 1;
						break;
					}
				}
			}
			if(idx == set.length) cnt += 1;
		}
		ArrayList<Character> arr = new ArrayList<Character>();
		for(int i=0; i<set.length; i++) {
			arr.add(menu[set[i]]);
		}
		if(cnt > 1) count.put(arr, cnt);
		return;
	}
}
