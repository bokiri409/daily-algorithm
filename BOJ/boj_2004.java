package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.08.04 daily algo/commit
 */

public class boj_2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		int five = five(n) - five(m) - five(n-m);
		int two = two(n) - two(m) - two(n-m);
		
		System.out.print(Math.min(five, two));
		br.close();
	}
	
	static int five(long num) {
		int cnt = 0;
		while(num >= 5) {
			cnt += num/5;
			num /= 5;
		}
		
		return cnt;
	}
	
	static int two(long num) {
		int cnt = 0;
		while(num >= 2) {
			cnt += num/2;
			num /=2;
		}
		return cnt;
	}
	
}
