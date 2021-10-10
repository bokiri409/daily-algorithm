package Programmers;

import java.util.PriorityQueue;

/*
 * 2021.10.10 daily algo/commit
 * 
 * 일반 ArrayList 는 효율성 테스트에서 시간초과
 * => heap (우선순위 큐)를 사용한다!
 * => 자동 정렬!
 */

public class prg_L2_더맵게 {
	
	static int[] scoville = {1, 2, 3, 9, 10, 12};
//	static int[] scoville = {1, 1, 100};
	static int K = 7;

	public static void main(String[] args) {
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
//        ArrayList<Integer> newScoville = new ArrayList<Integer>(); // 시간초과!
        PriorityQueue<Integer> newScoville = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) {
        	newScoville.add(scoville[i]);
        }
        
        answer = mix(newScoville, K);
        
        return answer;
    }
	
	public static int mix(PriorityQueue<Integer> newScoville, int K) {
		int num = 0; // 섞은 횟수
		while(newScoville.size() > 1) {
			if(newScoville.peek() >= K) {
				return num;
			}
			else {
				int newK = newScoville.poll() + newScoville.poll()*2; // 믹스된 새로운 스코빌 지수
				newScoville.add(newK); // 새로만든 스코빌 지수 추가
				num += 1;
			}
		}
		
		if(newScoville.peek() >= K) { // 배열의 수가 하나일 때 스코빌 지수 검사
			return num;
		}
		return -1;
	}

}
