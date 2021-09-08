package BOJ;

import java.util.Scanner;


public class boj_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		word = word.toUpperCase();
		
		int[] count = new int[26];

        for (int i=0; i<word.length(); i++) {
            int num = word.charAt(i) - 'A';
            count[num] += 1;
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if(max < count[i]){
                max = count[i];
                answer = (char)(i+'A');
            } else if (max == count[i]){
                answer = '?';
            }
        }
        
        System.out.println(answer);
		sc.close();
	}

}
