package BOJ;

import java.util.Scanner;

public class boj_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine().trim();
		if(word.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(word.split(" ").length);
		}
		sc.close();
	}
}
