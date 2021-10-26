package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.10.26 daily algo/commit
 * 
 * 프로그래머스 - L3 Summer/Winter Coding 2018
 * stations은 오름차순으로 정렬되어 있다.
 * 
 * tip. 효율성 높이기
 * 1. Loop 개선
 * 2. 적절한 데이터 구조 사용
 * 3. 불필요한 오브젝트 제거
 */

public class prg_L3_1A_기지국설치_풀이 {
	
	static int n = 11;
	static int[] stations = {4, 11};
	static int w = 1;

	public static void main(String[] args) {
		System.out.println(solution(n, stations, w));
	}
	
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // 기지국이 설치되어 있을 때 // 효율성 테스트에서 시간초과
//        Queue<Integer> sq = new LinkedList<Integer>();
//        for(int s : stations) sq.offer(s);
        
        // 큐를 사용하는 것보다 인덱스를 활용하는 것이 더 효율적이다. (object타입(큐)보다 primitive타입을 사용하는 것이 더 효율적)
        int idx = 0;

        int position = 1;
        // Loop는 더 줄일 수 없음.
        while(position <= n) {
//        	if(!sq.isEmpty() && sq.peek() - w <= position) {
//        		position = sq.poll() + w + 1;
//        	}
        	if(idx < stations.length && stations[idx] - w <= position) {
        		position = stations[idx] + w + 1;
        		idx += 1;
        	}
        	else {
        		answer += 1;
        		position += w * 2 + 1;
        	}
        }

        return answer;
    }

}
