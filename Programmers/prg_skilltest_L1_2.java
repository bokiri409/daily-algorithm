package Programmers;

public class prg_skilltest_L1_2 {
	
	static int n = 3;

	public static void main(String[] args) {
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		String answer = "";
		String word1 = "¼ö";
		String word2 = "¹Ú";
		
		int a = n / 2;
		int b = n % 2;
		
		for(int i=0; i<a; i++) {
			answer += (word1 + word2);
		}
		if(b == 1) answer += word1;
        return answer;
    }
}
