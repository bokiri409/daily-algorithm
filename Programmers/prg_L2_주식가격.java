package Programmers;

import java.util.Stack;

/*
 * 2021.08.26 daily algo/commit
 * 
 * ������ Ȱ���Ͽ� ȿ���� ���̱�
 * �����ڷ� : https://girawhale.tistory.com/7
 */

public class prg_L2_�ֽİ��� {
	
	static int[] prices = {2, 1, 2, 1, 2, 1};

	public static void main(String[] args) {
		solution(prices);
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i=1; i<prices.length; i++) {
        	if(!stack.isEmpty() && (prices[i] >= prices[stack.peek()])) { // ������ ���� ����������� �˻��Ѵ�
        		stack.push(i);
        	}
        	else {
        		while(!stack.isEmpty() && (prices[i] < prices[stack.peek()])) {
        			answer[stack.peek()] = i-stack.peek(); // �ֽ��� �������� �ش� �ε���
        			stack.pop();
        		}
        		stack.push(i);
        	}
        }
        stack.pop(); // ������ �ֽ��� ������ 0
        
        while(!stack.isEmpty()) {
        	answer[stack.peek()] = answer.length-1-stack.peek();
        	stack.pop();
        }
        for(int i=0; i<answer.length; i++) {
        	System.out.print(answer[i]+" ");
        }
        
        return answer;
    }

}
