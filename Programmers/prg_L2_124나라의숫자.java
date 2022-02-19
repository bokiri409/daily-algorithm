package Programmers;

/*
 * 2021.02.19 daily algo/commit
 * int�迭�� �ð��ʰ�
 * 3���� ������ �������� �̿��Ͽ� Ǯ���Ѵ�.
 * 3�� ����� -1�� ���ش�.
 */

public class prg_L2_124�����Ǽ��� {
	
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
