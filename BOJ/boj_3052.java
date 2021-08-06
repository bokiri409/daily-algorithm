package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.08.06 daily algo/commit
 */

public class boj_3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		
		boolean[] rest = new boolean[42]; //나머지 존재 여부
		for(int i=0; i<10; i++) {
			N = Integer.parseInt(br.readLine());
			rest[N%42] = true;
		}
		
		int cnt = 0;
		for(int i=0; i<rest.length; i++) {
			if(rest[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}

}
