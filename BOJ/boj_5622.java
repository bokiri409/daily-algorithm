package BOJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 2021.01.07 daily algo/commit
 * 
 * ¹®ÀÚ¿­
 */

public class boj_5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int n = 2;
		for(int i=65; i<=90; i++) {
			if(n == 7 || n == 9) {
				for(int j=0; j<4; j++) {
					map.put((char) i, n);
					i++;
				}
			}
			else {
				for(int j=0; j<3; j++) {
					map.put((char) i, n);
					i++;
				}
			}
			i--;
			n++;
		}
		
		int time = 0;
		String word = sc.next();
		for(int i=0; i<word.length(); i++) {
			time += map.get(word.charAt(i)) + 1;
		}
		sc.close();
		System.out.println(time);
	}
}
