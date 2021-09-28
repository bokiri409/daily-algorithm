package Programmers;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * 2021.09.28 daily algo/commit
 * 
 * Programmers weekly 8 - 정렬
 */

public class prg_week8_최소직사각형 {
	
//	static int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
	static int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

	public static void main(String[] args) {
		System.out.println(solution(sizes));
	}
	
	public static int solution(int[][] sizes) {
        int answer = 0;
        
        ArrayList<Integer> max = new ArrayList<Integer>();
        ArrayList<Integer> min = new ArrayList<Integer>();
        
        for(int i=0; i<sizes.length; i++) {
        	max.add(Math.max(sizes[i][0], sizes[i][1]));
        	min.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        max.sort(Comparator.reverseOrder());
        min.sort(Comparator.reverseOrder());

        answer = max.get(0) * min.get(0);
        return answer;
    }

}
