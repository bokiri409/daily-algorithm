package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2021.06.25 daily algo/commit
 */

public class boj_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] vps = new String[T];
		for(int i=0; i<T; i++) {
			vps[i] = br.readLine();
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(check(vps[i]));
		}
	}
	
	static String check(String vps) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<vps.length(); i++) {
			if(vps.charAt(i) == '(') {
				stack.push(1);
			}
			else {
				if(stack.isEmpty()) {
					return "NO";
				}
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			return "YES";
		}
		else {
			return"NO";
		}
	}

}
