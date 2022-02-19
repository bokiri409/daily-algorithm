package Programmers;

/*
 * 2021.02.19 daily algo/commit
 * int배열은 시간초과
 * 3으로 나눠서 나머지를 이용하여 풀이한다.
 * 3의 배수는 -1을 해준다.
 */

public class prg_L2_124나라의숫자 {
	
	static int n = 10;

	public static void main(String[] args) {
		System.out.println(solution(n));
	}
	
	public static String solution(int n) {
		String answer = "";
//		int[] num = {4, 1, 2};
		String[] num = {"4", "1", "2"};
		while(true) {
			if(n == 0) break;
			int remain = n % 3;
			n /= 3;
			
			if(remain == 0) n--;
			answer = num[remain] + answer;
		}
        return answer;
    }

}
