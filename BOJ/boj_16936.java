package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 2021.12.07 daily algo/commit
 * 
 * DFS를 이용하여 모든 값을 구하고 답이되는 배열 한개를 출력하고자 했지만 시간초과.
 * 
 * 나누기3, 곱하기2 일 때
 * 먼저 3으로 나누어 떨어지는 횟수를 구하고 제일 많이 나누어 떨어지는 값이 먼저이므로 내림차순 정렬한다.
 * 다음 곱하기 2는 수가 커질수밖에 없으므로 3으로 나누어 떨어지는 횟수가 같은 값들은 오름차순 정렬해주면 된다.
 * 
 * compare 정렬 Long형일 때는 return값을 long으로 변환해줘야 함
 */

public class boj_16936 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] arr = new long[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][1] = sc.nextLong();
			long n = arr[i][1];
			while(true) {
				if(n % 3 == 0) { // 3으로 나누어 떨어지는 횟수
					arr[i][0] += 1;
					n /= 3;
				}
				else break;
			}
		}
		
		Arrays.sort(arr, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) {
					// 0번째 인덱스가 같으면 1번째 인덱스는 오름차순
//					return (o1[1] - o2[1]); 
					return Long.compare(o1[1], o2[1]);
				}
				else {
					// 0번째 인덱스 내림차순
//					return (o2[0] - o1[0]);
					return Long.compare(o2[0], o1[0]);
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i][1]+" ");
		}
		
		sc.close();
	}
	
}
