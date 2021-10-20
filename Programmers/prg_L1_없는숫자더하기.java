package Programmers;

/*
 * 2021.10.20 daily algo/commit
 * 
 * 프로그래머스 월간 코드 챌린지 시즌3
 * ※0~9까지 모두 더한 수 45에서 numbers에 있는 수들을 빼주면 for문을 한번만 돌려서 결과값을 구할 수 있다.!
 */

public class prg_L1_없는숫자더하기 {
	
	static int[] numbers = {1,2,3,4,6,7,8,0};
	
	static boolean[] visited = new boolean[10];

	public static void main(String[] args) {
		System.out.println(solution(numbers));
	}
	
	public static int solution(int[] numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length; i++) {
        	visited[numbers[i]] = true;
        }
        
        for(int i=0; i<visited.length; i++) {
        	if(!visited[i]) answer += i;
        }
        
        return answer;
    }

}
