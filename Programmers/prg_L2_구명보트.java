package Programmers;

import java.util.Arrays;

/*
 * 2022.02.27 daily algo/commit
 * 
 * �ں�Ʈ�� ���� �ο��� �θ�!!!!!
 */

public class prg_L2_����Ʈ {
	
	static int[] people = {70, 50, 80, 50};
	static int limit = 100;

	public static void main(String[] args) {
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
        int answer = 0;
        int weight = 0;
        int idx = 0;
        for(int i=people.length-1; i>=0; i--) {
        	if(i == idx) {
        		answer += 1;
        		break;
        	}
        	if(i < idx) break;
        	
        	weight += people[i];
        	weight += people[idx];
        	answer += 1;
        	if(weight > limit) {
        		weight = 0;
        	}
        	else {
        		weight = 0;
        		idx += 1;
        	}
        }
        return answer;
    }
}
