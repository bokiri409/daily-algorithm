package Programmers;

/*
 * 2021.10.21 daily algo/commit
 * 
 * 프로그래머스 Summer/Winter coding (~2018)
 * 조합
 */

public class prg_L1_소수만들기 {
	
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
	
	public static void combination(int cnt, int n, int start, int[] nums) { // cnt : 현재까지 뽑은 개수, start : 조합의 시작점 인덱스
		// r개 뽑기
		if(cnt == 3) {
			System.out.println("# "+num);
			for(int i=2; i<=Math.sqrt(num); i++) { // 소수판별
				if(num % i == 0) { // 소수가 아니면
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
