package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.06.28 daily algo/commit
 */

public class boj_2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int num = 0;
		int idx = 0;
		
		for(int i=1; i<=9; i++) {
			num = Integer.parseInt(br.readLine());
			if(num > max) {
				max = num;
				idx = i;
			}
		}
		System.out.print(max+"\n"+idx);
	}

}
