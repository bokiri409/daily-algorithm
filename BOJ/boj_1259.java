package BOJ;

import java.util.Scanner;

/*
 * 2021.02.15 daily algo/commit
 * 
 * palindrome
 */

public class boj_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			int num = 0;
			if(str.equals("0")) break;
			for(int i=0; i<str.length()/2; i++) {
				if(str.charAt(i) == str.charAt(str.length() - i - 1)) {
					num += 1;
				}
				else break;
			}
			if(num == str.length()/2) System.out.println("yes");
			else System.out.println("no");
		} 
		sc.close();
	}

}
