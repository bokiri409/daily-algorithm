package Programmers;

/*
 * 2021.10.21 daily algo/commit
 * 
 * ���α׷��ӽ� ���� �ڵ� ç���� ����1
 */

public class prg_L1_���� {
	
	static int[] a = {1,2,3,4};
	static int[] b = {-3,-1,0,2};

	public static void main(String[] args) {
		System.out.println(solution(a, b));
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
        	answer += a[i] * b[i];
        }
        
        return answer;
    }

}
