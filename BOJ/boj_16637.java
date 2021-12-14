package BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2021.12.12 daily algo/commit
 * 
 * Brute Force, Combination
 */

public class boj_16637 {
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] numbers = new int[N/2+1];
		boolean[] visited = new boolean[N/2+1];
		
		char[] operators = new char[N/2];
		boolean[] cal = new boolean[N/2];
		String formula = sc.next();
		
		for(int i=0; i<N; i++) {
			if(i%2 == 0) numbers[i/2] = formula.charAt(i) - '0'; // 숫자
			else operators[i/2] = formula.charAt(i); // 연산자
		}
		
		for(int i=0; i<=numbers.length/2; i++) {
			combination(numbers, operators, visited, cal, numbers.length, i, 0);
		}
		if(numbers.length == 1) max = numbers[0];
		System.out.println(max);
		sc.close();
	}
	
	public static void combination(int[] numbers, char[] operators, boolean[] visited, boolean[] cal, int n, int r, int start) {
		if(r == 0) {
			int[] num = numbers.clone();
			
//			System.out.println(Arrays.toString(visited));
			
			Arrays.fill(cal, false);
			for(int i=0; i<n-1; i++) {
				if(visited[i] && visited[i+1]) {
					if(operators[i] == '+') {
						num[i] = num[i] + num[i+1]; 
						num[i+1] = 0;
					}
					else if(operators[i] == '-') {
						num[i] = num[i] - num[i+1];
						num[i+1] = 0;
					}
					else {
						num[i] = num[i] * num[i+1];
						num[i+1] = 1;
					}
//					cal[i] = true;
					i += 1;
				}
			}
			
//			System.out.println(Arrays.toString(num));
			
//			boolean check = false;
			int answer = num[0];
			for(int i=0; i<operators.length; i++) {
				if(operators[i] == '+') answer += num[i+1];
				else if(operators[i] == '-') answer -= num[i+1];
				else answer *= num[i+1];
				
				/*
				if(cal.length == 1 && cal[0] == true) {
					answer = num[0];
					break;
				}
				if(!cal[i]) {
					if(operators[i] == '+') {
						if(!check) answer += num[i] + num[i+1];
						else answer += numbers[i+1];
					}
					else if(operators[i] == '-') {
						if(!check) answer += num[i] - num[i+1];
						else {
//							System.out.println(answer+" "+num[i+1]);
							answer -= num[i+1];
//							System.out.println(answer);
						}
					}
					else {
						if(!check) answer += num[i] * num[i+1];
						else answer *= num[i+1];
					}
					System.out.println("answer2 "+answer);
					check = true;
				}
				*/
				
			}
			if(max < answer) max = answer;
			return;
		}
		
		for(int i=start; i<n-1; i++) {
			if(!visited[i] && !visited[i+1]) {
				visited[i] = true;
				visited[i+1] = true;
				combination(numbers, operators, visited, cal, n, r-1, i+1);
				visited[i] = false;
				visited[i+1] = false;
			}
		}
	}
}

