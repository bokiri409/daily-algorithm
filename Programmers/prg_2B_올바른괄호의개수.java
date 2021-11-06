package Programmers;

/*
 * 2021.11.06 daily algo/commit
 * 
 * 카탈란 점화식으로 간단하게 풀 수 있었지만 dfs로도 풀어보자
 * 참고 풀이 : https://tosuccess.tistory.com/173
 */

public class prg_2B_올바른괄호의개수 {

	static int n = 3;
	
	public static void main(String[] args) {
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int[] catalan = new int[n+1];
		
		// 카탈란 수 점화식 이용
		catalan[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				catalan[i] += catalan[j]*catalan[i-j-1];
			}
		}
		
        return catalan[n];
    }
	
}
