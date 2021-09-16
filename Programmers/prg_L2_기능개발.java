package Programmers;

import java.util.ArrayList;

/*
 * 2021.09.16 daily algo/commit
 */

public class prg_L2_기능개발 {
	
	static int[] progresses = {93, 30, 55};
	static int[] speeds = {1, 30, 5};

	public static void main(String[] args) {
		System.out.println(solution(progresses, speeds));
	}
	
	public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int[] remainDay = new int[progresses.length];
        ArrayList<Integer> release = new ArrayList<Integer>();
        
        for(int i=0; i<progresses.length; i++) {
        	remainDay[i] = (int)(Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        
        for(int i=0; i<remainDay.length; i++) {
        	int num = 0; // 배포되는 기능 수
        	if(remainDay[i] > 0) {
        		int standard = remainDay[i];
        		for(int j=i; j<remainDay.length; j++) {
        			if(remainDay[j] <= 0) continue;
        			remainDay[j] -= standard;
        		}
        		
        		for(int j=i; j<remainDay.length; j++) {
        			if(remainDay[j] <= 0) { // 남은기간이 없으면 기능 배포
        				num++;
        			}
        			else {
        				break; // 연속된 날까지만 
        			}
        		}
        	}
        	if(num>0) release.add(num);
        }
        
        return release;
    }

}
