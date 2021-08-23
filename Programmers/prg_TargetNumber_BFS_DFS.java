package Programmers;

/*
 * 2021.08.23 daily algo/commit
 * 
 * 프로그래머스 Level 2 - BFS/DFS - 타겟넘버
 */

public class prg_TargetNumber_BFS_DFS {
	
	static int[] numbers = {1,1,1,1,1};
	static int target = 3;

	public static void main(String[] args) {
		System.out.println(solution(numbers, target));
	}
	
	private static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
	
	private static int dfs(int[] numbers, int target, int level, int sum) {
		if(level == numbers.length) {
			if(target == sum) {
				return 1;
			}
			else {
				return 0;
			}
		}
		return dfs(numbers, target, level+1, sum+numbers[level])
				+ dfs(numbers, target, level+1, sum-numbers[level]);
		
	}
	
	

}
