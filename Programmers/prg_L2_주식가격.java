package Programmers;

import java.util.Stack;

/*
 * 2021.08.26 daily algo/commit
 * 
 * 스택을 활용하여 효율성 높이기
 * 참고자료 : https://girawhale.tistory.com/7
 */

public class prg_L2_주식가격 {
	
	static int[] prices = {2, 1, 2, 1, 2, 1};

	public static void main(String[] args) {
		solution(prices);
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i=1; i<prices.length; i++) {
        	if(!stack.isEmpty() && (prices[i] >= prices[stack.peek()])) { // 스택이 먼저 비었는지부터 검사한다
        		stack.push(i);
        	}
        	else {
        		while(!stack.isEmpty() && (prices[i] < prices[stack.peek()])) {
        			answer[stack.peek()] = i-stack.peek(); // 주식이 떨어지면 해당 인덱스
        			stack.pop();
        		}
        		stack.push(i);
        	}
        }
        stack.pop(); // 마지막 주식은 무조건 0
        
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
