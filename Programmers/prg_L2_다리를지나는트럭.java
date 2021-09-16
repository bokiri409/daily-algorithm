package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.09.16 daily algo/commit
 * 
 * PG_L2_stack/queue
 * ������ �� �����ؼ� ���� �� => �ð��ʰ� �� �� �ִ�.
 * ���� :https://velog.io/@rari_1110/Queue-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EC%A7%80%EB%82%98%EB%8A%94-%ED%8A%B8%EB%9F%AD-JAVA
 */

public class prg_L2_�ٸ���������Ʈ�� {
	
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
        
        int sum = 0; // �ٸ� �� Ʈ���� ���� ��
        int total_time = 0; // ��ü �ɸ� �ð�
        
        for(int i=0; i<truck_weights.length; i++) {
        	while(true) {
        		if(q.size() == bridge_length) { // �ٸ��� Ʈ���� �� á�ٸ�
	//				total_time++; // �ð��� ���� ����
					sum -= q.poll();
        		}
        		else {
        			if(sum + truck_weights[i] <= weight) { // ���ο� Ʈ���� ���� ���
            			if(i == truck_weights.length-1) { // ������ Ʈ�� ���� ��
            				total_time += bridge_length;
            				break;
            			}
            			q.offer(truck_weights[i]);
            			if(q.peek() == 0) q.poll();
            			total_time++;
            			sum += truck_weights[i];
            			break;
            		}
        			else { // ���� �ʰ��� ��
        				q.offer(0); // �� �� �־��ֱ�
        				total_time++;
        			}
        		}
        		
        		/*	�ð��ʰ� ���� ���ǹ�
        		
	        		if(sum + truck_weights[i] <= weight && num < bridge_length) { // ���ο� Ʈ���� ���� ���
	        			if(i == truck_weights.length-1) { // ������ Ʈ�� ���� ��
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
	        		else { // �� Ʈ�� ���� �Ұ� ���
	        			if(q.size() == bridge_length) { // �ٸ� ���� ��� ��
	//        				total_time++; // �ð��� ���� ����
	        				sum -= q.poll();
	        				num -= 1;
	//        				continue;
	        			}
	        			else {
	        				q.offer(0); // �� �� �־��ֱ�
	        				total_time++;
	        			}
	        		}
        		 */
        	}
        }
        return total_time+1;
    }
	
}
