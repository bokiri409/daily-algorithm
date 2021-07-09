package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2021.07.10 daily algo/commit
 */

public class boj_2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] prefixs = new String[S.length()];
		
		for(int i=0; i<S.length(); i++) {
			prefixs[i] = S.substring(i, S.length());
		}
		Arrays.sort(prefixs);
		
		for(int i=0; i<prefixs.length; i++) {
			System.out.println(prefixs[i]);
		}
		
		br.close();
	}

}
