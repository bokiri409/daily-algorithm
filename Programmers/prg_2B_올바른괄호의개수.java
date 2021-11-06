package Programmers;

/*
 * 2021.11.06 daily algo/commit
 * 
 * īŻ�� ��ȭ������ �����ϰ� Ǯ �� �־����� dfs�ε� Ǯ���
 * ���� Ǯ�� : https://tosuccess.tistory.com/173
 */

public class prg_2B_�ùٸ���ȣ�ǰ��� {

	static int n = 3;
	
	public static void main(String[] args) {
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int[] catalan = new int[n+1];
		
		// īŻ�� �� ��ȭ�� �̿�
		catalan[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				catalan[i] += catalan[j]*catalan[i-j-1];
			}
		}
		
        return catalan[n];
    }
	
}
