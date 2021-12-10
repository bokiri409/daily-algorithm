package BOJ;

import java.util.Scanner;

/*
 * 2021.12.09 daily algo/commit
 */

public class boj_16937 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int N = sc.nextInt();
		int[][] stickers = new int[N][2];
		for(int i=0; i<N; i++) {
			stickers[i][0] = sc.nextInt();
			stickers[i][1] = sc.nextInt();
		}
		
		int sum = 0; // ³ÐÀÌ ÇÕ
		int max = 0; // ÃÖ´ë ³ÐÀÌ
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W ||
						stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) {
					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
				}
				else if(stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W ||
						stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) {
					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
				}
				else if(stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
						stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) {
					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
				}
				else if(stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
						stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) {
					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
				}
				if(max < sum) max = sum;
			}
		}
		
		System.out.println(max);
		sc.close();
	}

}
