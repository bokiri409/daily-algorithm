package Programmers;

/*
 * 2021.10.21 daily algo/commit
 * 
 * ���α׷��ӽ� ���� �ڵ� ç���� ����2
 */

public class prg_L1_������ϱ� {
	
	static int[] absolutes = {4,7,12};
	static boolean[] signs = {true,false,true};

	public static void main(String[] args) {
		System.out.println(solution(absolutes, signs));
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<signs.length; i++) {
        	if(signs[i]) { // ����� ��
        		answer += absolutes[i];
        	}
        	else {
        		answer -= absolutes[i];
        	}
        }
        
        return answer;
    }

}
