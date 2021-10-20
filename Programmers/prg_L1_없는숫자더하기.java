package Programmers;

/*
 * 2021.10.20 daily algo/commit
 * 
 * ���α׷��ӽ� ���� �ڵ� ç���� ����3
 * ��0~9���� ��� ���� �� 45���� numbers�� �ִ� ������ ���ָ� for���� �ѹ��� ������ ������� ���� �� �ִ�.!
 */

public class prg_L1_���¼��ڴ��ϱ� {
	
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
