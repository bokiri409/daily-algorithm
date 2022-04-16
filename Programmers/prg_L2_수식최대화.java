package Programmers;

import java.util.ArrayList;

/*
 * 2021.03.06 daily algo/commit
 * 
 * 결과값의 자료형을 주의하자!
 */

public class prg_L2_수식최대화 {
	
	static String expression = "100-200*300-500+20";
//	static String expression = "50*6-3*2";
	static long max = 0;
	static ArrayList<Character> operator;
	static ArrayList<Long> number;

	public static void main(String[] args) {
		System.out.println(solution(expression));
	}

	public static long solution(String expression) {
		number = new ArrayList<Long>();
		ArrayList<Long> number_t = new ArrayList<Long>();
		operator = new ArrayList<Character>();
		ArrayList<Character> operator_t = new ArrayList<Character>();
		ArrayList<Character> op = new ArrayList<Character>();
		int start = 0;
		for(int i=0; i<expression.length(); i++) {
			if(expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '+') {
				operator.add(expression.charAt(i));
				operator_t.add(expression.charAt(i));
				boolean visit = false;
				for(int j=0; j<op.size(); j++) {
					if(op.get(j) == expression.charAt(i)) {
						visit = true;
						break;
					}
				}
				if(!visit) op.add(expression.charAt(i));
				number.add(Long.parseLong(expression.substring(start, i)));
				number_t.add(Long.parseLong(expression.substring(start, i)));
				start = i + 1;
			}
			if(i == expression.length()-1) {
				number.add(Long.parseLong(expression.substring(start, i+1)));
				number_t.add(Long.parseLong(expression.substring(start, i+1)));
			}
		}
		
		int[] cal = new int[op.size()];
		boolean[] visited = new boolean[op.size()];
		calculation(op, operator_t, number_t, 0, op.size(), cal, visited);
		
        return max;
    }
	
	public static void calculation(ArrayList<Character> op, ArrayList<Character> operator_t, ArrayList<Long> number_t, int r, int n, int[] cal, boolean[] visited) {
		if(r == n) {
			for(int i=0; i<cal.length; i++) {
				long result = 0;
				int idx = 0;
				while(operator_t.size() > 0) {
					if(idx == operator_t.size()) break;
					if(op.get(cal[i]) == operator_t.get(idx)) {
						if(op.get(cal[i]) == '-') result = (number_t.get(idx) - number_t.get(idx+1));
						if(op.get(cal[i]) == '*') result = (number_t.get(idx) * number_t.get(idx+1));
						if(op.get(cal[i]) == '+') result = (number_t.get(idx) + number_t.get(idx+1));
						number_t.set(idx, result);
						number_t.remove(idx+1);
						operator_t.remove(idx);
						continue;
					}
					idx += 1;
				}
			}
			max = Math.max(max, Math.abs(number_t.get(0)));
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				cal[r] = i;
				calculation(op, operator_t, number_t, r+1, n, cal, visited);
				number_t.clear();
				operator_t.clear();
				for(Long in : number) {
					number_t.add(in);
				}
				for(Character c : operator) {
					operator_t.add(c);
				}
				visited[i] = false;
			}
		}
	}
}
