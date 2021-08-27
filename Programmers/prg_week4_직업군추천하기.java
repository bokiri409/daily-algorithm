package Programmers;

import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2021.08.27 daily algo/commit
 * 
 * �����ؽ� ���� �����ڷ� : https://unluckyjung.github.io/java/2020/12/19/Java_Overlay_Map/
 * String ���� �� ��
 * str1.compareTo(str2) < 0 : str1�� str2���� ���� ��
 * str1.compareTo(str2) = 0 : �����ܾ�
 * str1.compareTo(str2) > 0 : str1�� str2���� ���� ��
 */

public class prg_week4_��������õ�ϱ� {
	
	static String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
	static String[] languages = {"JAVA", "JAVASCRIPT"};
	static int[] preference = {1,2};
	
	static HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String,Integer>>();
	static HashMap<String, Integer> innerMap;
	static String[] job = new String[5];
	static int[] score = new int[5];

	public static void main(String[] args) {
		System.out.println(solution(table, languages, preference));
	}
	
	public static String solution(String[] table, String[] languages, int[] preference) {
		StringTokenizer st;
		for(int i=0; i<table.length; i++) { // ���� ���� ���̺� �� �����
			st = new StringTokenizer(table[i]);
			job[i] = st.nextToken();
			innerMap = new HashMap<String, Integer>();
			map.put(job[i], innerMap);
			for(int j=5; j>0; j--) {
				innerMap.put(st.nextToken(), j);
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<languages.length; j++) {
				if(map.get(job[i]).get(languages[j]) == null) {
					score[i] += 0;
				}
				else {
					score[i] += (preference[j] * map.get(job[i]).get(languages[j]));
				}
			}
		}
		
		int max = 0;
		String answer = "";
		for(int i=0; i<score.length; i++) {
			if(max < score[i]) {
				max = score[i];
				answer = job[i];
			}
			else if(max == score[i]) {
				if(answer.compareTo(job[i]) > 0) {
					answer = job[i];
				}
			}
			
		}
        return answer;
    }

}
