package BOJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 2022.03.01 daily algo/commit
 */

public class boj_1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<N; i++) {
			map.put(sc.nextInt(), 1);
		}
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			if(map.containsKey(sc.nextInt())) System.out.println(1);
			else System.out.println(0);
		}
		
		sc.close();
	}

}
