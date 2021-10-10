package Programmers;

import java.util.PriorityQueue;

/*
 * 2021.10.10 daily algo/commit
 * 
 * �Ϲ� ArrayList �� ȿ���� �׽�Ʈ���� �ð��ʰ�
 * => heap (�켱���� ť)�� ����Ѵ�!
 * => �ڵ� ����!
 */

public class prg_L2_���ʰ� {
	
	static int[] scoville = {1, 2, 3, 9, 10, 12};
//	static int[] scoville = {1, 1, 100};
	static int K = 7;

	public static void main(String[] args) {
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
//        ArrayList<Integer> newScoville = new ArrayList<Integer>(); // �ð��ʰ�!
        PriorityQueue<Integer> newScoville = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) {
        	newScoville.add(scoville[i]);
        }
        
        answer = mix(newScoville, K);
        
        return answer;
    }
	
	public static int mix(PriorityQueue<Integer> newScoville, int K) {
		int num = 0; // ���� Ƚ��
		while(newScoville.size() > 1) {
			if(newScoville.peek() >= K) {
				return num;
			}
			else {
				int newK = newScoville.poll() + newScoville.poll()*2; // �ͽ��� ���ο� ���ں� ����
				newScoville.add(newK); // ���θ��� ���ں� ���� �߰�
				num += 1;
			}
		}
		
		if(newScoville.peek() >= K) { // �迭�� ���� �ϳ��� �� ���ں� ���� �˻�
			return num;
		}
		return -1;
	}

}
