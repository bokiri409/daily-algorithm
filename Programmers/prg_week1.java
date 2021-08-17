package Programmers;

public class prg_week1 {

	public static void main(String[] args) {
		System.out.print(solution(3, 20, 4));
	}
	
	public static long solution(int price, int money, int count) {
		long sum = 0; // ÃÑ ÀÌ¿ë·á
		for(int i=1; i<=count; i++) {
			sum += price * i;
		}
		
		long answer = money - sum;
		if(money > sum) {
			answer = 0;
		}
		else {
			answer = Math.abs(answer);
		}
        
        return answer;
    }

}
