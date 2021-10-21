package Programmers;

/*
 * 2021.10.21 daily algo/commit
 * 
 * ���α׷��ӽ� Summer/Winter coding (~2018)
 * ����
 */

public class prg_L1_�Ҽ������ {
	
	static int[] nums = {1,2,3,4};
	static int num = 0;
	static int result = 0;

	public static void main(String[] args) {
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
        combination(0, nums.length, 0, nums);
        return result;
    }
	
	public static void combination(int cnt, int n, int start, int[] nums) { // cnt : ������� ���� ����, start : ������ ������ �ε���
		// r�� �̱�
		if(cnt == 3) {
			System.out.println("# "+num);
			for(int i=2; i<=Math.sqrt(num); i++) { // �Ҽ��Ǻ�
				if(num % i == 0) { // �Ҽ��� �ƴϸ�
					return;
				}
			}
			result += 1;
			return;
		}
		
		for(int i=start; i<n; i++) {
			num += nums[i];
			combination(cnt+1, n, i+1, nums);
			num -= nums[i];
		}
	}

}
