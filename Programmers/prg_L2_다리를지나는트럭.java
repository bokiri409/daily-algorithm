package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.09.16 daily algo/commit
 * 
 * PG_L2_stack/queue
 * 조건을 잘 생각해서 나눌 것 => 시간초과 날 수 있다.
 * 참고 :https://velog.io/@rari_1110/Queue-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EC%A7%80%EB%82%98%EB%8A%94-%ED%8A%B8%EB%9F%AD-JAVA
 */

public class prg_L2_다리를지나는트럭 {
	
//	static int bridge_length = 2;
	static int bridge_length = 100;
//	static int weight = 10;
	static int weight = 100;
//	static int[] truck_weights = {7,4,5,6};
	static int[] truck_weights = {10};

	public static void main(String[] args) {
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<Integer>();
        
        int sum = 0; // 다리 위 트럭의 무게 합
        int total_time = 0; // 전체 걸린 시간
        
        for(int i=0; i<truck_weights.length; i++) {
        	while(true) {
        		if(q.size() == bridge_length) { // 다리에 트럭이 다 찼다면
	//				total_time++; // 시간이 들지 않음
					sum -= q.poll();
        		}
        		else {
        			if(sum + truck_weights[i] <= weight) { // 새로운 트럭이 들어가는 경우
            			if(i == truck_weights.length-1) { // 마지막 트럭 진입 시
            				total_time += bridge_length;
            				break;
            			}
            			q.offer(truck_weights[i]);
            			if(q.peek() == 0) q.poll();
            			total_time++;
            			sum += truck_weights[i];
            			break;
            		}
        			else { // 무게 초과일 때
        				q.offer(0); // 빈 값 넣어주기
        				total_time++;
        			}
        		}
        		
        		/*	시간초과 나는 조건문
        		
	        		if(sum + truck_weights[i] <= weight && num < bridge_length) { // 새로운 트럭이 들어가는 경우
	        			if(i == truck_weights.length-1) { // 마지막 트럭 진입 시
	        				total_time += bridge_length;
	        				break;
	        			}
	        			q.offer(truck_weights[i]);
	        			if(q.peek() == 0) q.poll();
	        			total_time++;
	        			sum += truck_weights[i];
	        			num += 1;
	        			break;
	        		}
	        		else { // 새 트럭 진입 불가 경우
	        			if(q.size() == bridge_length) { // 다리 전부 통과 시
	//        				total_time++; // 시간이 들지 않음
	        				sum -= q.poll();
	        				num -= 1;
	//        				continue;
	        			}
	        			else {
	        				q.offer(0); // 빈 값 넣어주기
	        				total_time++;
	        			}
	        		}
        		 */
        	}
        }
        return total_time+1;
    }
	
}
