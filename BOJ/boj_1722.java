package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1722 {
	
	static int n,c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		c = sc.nextInt(); // 소문제 번호
		
		if(c == 1) {
			long k = sc.nextLong();
			case1(n, k);
		} else {
			int[] nums = new int[n];
			for(int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			case2(n, nums);
		}
		sc.close();
	}
	
	// k번째인 수열 찾기
	private static void case1(int n, long k) {
		ArrayList<Integer> ans = new ArrayList<>();
		boolean[] arr = new boolean[n+1];
		long cnt = 0; // 순서 
		// n자리부터 차례대로 순서 비교하기 
		for(int i=1; i<=n; i++) {
			if(!arr[i]) {
				long num = factorial(n-ans.size()-1);
				cnt += num;
				// 구하고자 하는 순서보다 클 때 
				if(cnt >= k) {
					ans.add(i);
					arr[i] = true;
					i = 0;
					cnt -= num;
				}
			}
			if(ans.size() == n) {
//				System.out.println(ans);
				for(int l=0; l<ans.size(); l++) {
					System.out.print(ans.get(l)+" ");
				}
				return;
			}
		}
	}

	// 주어진 순열의 순서 찾기 
	private static void case2(int n, int[] nums) {
		boolean[] arr = new boolean[n+1];
		long cnt = 0;
		for(int i=0; i<nums.length; i++) {
			arr[nums[i]] = true;
			for(int j=1; j<nums[i]; j++) {
				if(!arr[j]) {
					cnt += factorial(n-i-1);
				}
			}
		}
		System.out.println(cnt+1);
	}
	
	private static long factorial(int x) {
		if(x == 1 || x == 0) return 1;
		else return x * factorial(x-1); 
	}
}
