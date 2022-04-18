package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 2022.04.18 daily algo/commit
 * 
 * ���� �󵵿� ���� Ʃ�� ������ �ľ��Ѵ�.
 * => ���� ���� ���ü��� 1���� ����� ����
 */

public class prg_L2_Ʃ�� {
	
	static String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		Map<String, Integer> tuple = new HashMap<String, Integer>();
        for(int i=1; i<s.length()-1; i++) {
        	if(s.charAt(i) == '{') {
        		int index = i+1;
        		while(true) {
        			if(s.charAt(index) == '}') {
        				String str = s.substring(i+1, index);
        				String[] arrStr = str.split(",");
        				for(String ss : arrStr) {
        					tuple.put(ss, tuple.getOrDefault(ss, 1)+1);
        				}
        				break;
        			}
        			if(s.charAt(index) == ',') {
        				index += 1;
        				continue;
        			}
        			index += 1;
        		}
        	}
        	if(s.charAt(i) == ',') continue;
        }
        
        // ���� ���� ���� ������ ����
        List<Entry<String, Integer>> entry = new ArrayList<Map.Entry<String,Integer>>(tuple.entrySet());
        Collections.sort(entry, new Comparator<Entry<String, Integer>>() {
        	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        		return o2.getValue() - o1.getValue();
        	}
		});
        
        int[] answer = new int[entry.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = Integer.parseInt(entry.get(i).getKey());
        }
        return answer;
    }
}
