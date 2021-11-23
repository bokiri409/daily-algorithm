package BOJ;

import java.util.Scanner;

/*
 * 2021.11.23 daily algo/commit
 */

public class boj_16968 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String licenseNumber = sc.next();
		int answer = 1;
		
		char kind = licenseNumber.charAt(0);
		if(kind == 'c') {
			answer *= 26;
		}
		else {
			answer *= 10;
		}
		
		for(int i=1; i<licenseNumber.length(); i++) {
			if(kind == licenseNumber.charAt(i) && licenseNumber.charAt(i) == 'c') {
				answer *= 25;
			}
			else if(kind == licenseNumber.charAt(i) && licenseNumber.charAt(i) == 'd') {
				answer *= 9;
			}
			else if(kind != licenseNumber.charAt(i) && licenseNumber.charAt(i) == 'c') {
				answer *= 26;
			}
			else if(kind != licenseNumber.charAt(i) && licenseNumber.charAt(i) == 'd') {
				answer *= 10;
			}
			
			kind = licenseNumber.charAt(i);
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	

}
