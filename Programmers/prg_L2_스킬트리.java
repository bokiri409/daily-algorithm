package Programmers;

import java.util.HashMap;
import java.util.Map;

/*
 * 2022.04.16 daily algo/commit
 */

public class prg_L2_스킬트리 {
	
	static String skill = "CBD";
	static String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

	public static void main(String[] args) {
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<skill.length(); i++) {
        	map.put(skill.charAt(i), i);
        }
        
        System.out.println(map);
        
        int cnt = 0;
        for(int i=0; i<skill_trees.length; i++) {
        	boolean chk = false;
        	int order = -1;
        	int next_order = -1;
        	for(int j=0; j<skill_trees[i].length(); j++) {
        		if(map.containsKey(skill_trees[i].charAt(j))) {
        			if(order == -1) {
        				// 0번째 스킬부터 시작해야 한다.
        				if(map.get(skill_trees[i].charAt(j)) != 0) {
        					chk = true;
        					break;
        				}
        				order = 0;
        			}
        			else {
        				if(order+1 != map.get(skill_trees[i].charAt(j))) {
        					chk = true;
        					break;
        				}
        				next_order = order + 1;
        				if(order > next_order) {
        					chk = true;
        					break;
        				}
        				else {
        					order = next_order;
        					next_order = -1;
        				}
        			}
        		}
        	}
        	if(!chk) cnt += 1;
        }
        
        return cnt;
    }
}
