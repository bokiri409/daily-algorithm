package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2021.06.24 daily algo/commit
 */

public class boj_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		String order;
		int X = 0;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			if(order.equals("push")) {
				X = Integer.parseInt(st.nextToken());
				stack.push(X);
			}
			else if(order.equals("pop")) {
				if(stack.empty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.pop());
				}
			}
			else if(order.equals("size")) {
				System.out.println(stack.size());
			}
			else if(order.equals("empty")) {
				if(stack.empty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
			else {
				if(stack.empty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.peek());
				}
			}
		}
		
		br.close();
	}

}
