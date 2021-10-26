package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.10.26 daily algo/commit
 * 
 * ���α׷��ӽ� - L3 Summer/Winter Coding 2018
 * stations�� ������������ ���ĵǾ� �ִ�.
 * 
 * tip. ȿ���� ���̱�
 * 1. Loop ����
 * 2. ������ ������ ���� ���
 * 3. ���ʿ��� ������Ʈ ����
 */

public class prg_L3_1A_��������ġ_Ǯ�� {
	
	static int n = 11;
	static int[] stations = {4, 11};
	static int w = 1;

	public static void main(String[] args) {
		System.out.println(solution(n, stations, w));
	}
	
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // �������� ��ġ�Ǿ� ���� �� // ȿ���� �׽�Ʈ���� �ð��ʰ�
//        Queue<Integer> sq = new LinkedList<Integer>();
//        for(int s : stations) sq.offer(s);
        
        // ť�� ����ϴ� �ͺ��� �ε����� Ȱ���ϴ� ���� �� ȿ�����̴�. (objectŸ��(ť)���� primitiveŸ���� ����ϴ� ���� �� ȿ����)
        int idx = 0;

        int position = 1;
        // Loop�� �� ���� �� ����.
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
