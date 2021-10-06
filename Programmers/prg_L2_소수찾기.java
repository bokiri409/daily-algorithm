package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/*
 * 2021.09.28 daily algo/commit
 * 
 * 프로그래머스 - 완전탐색 L2 소수찾기
 * 재귀, 조합을 이용하여 모든 숫자 완탐
 * 
 * n이 소수인지 아닌지 판별 : Math.sqrt(n)까지 나눠보면 된다.
 * 
 * 참고 : https://minhamina.tistory.com/37?category=837168
 */

public class prg_L2_소수찾기 {
	
//	static String numbers = "17";
	static String numbers = "233";
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	static boolean[] visited = new boolean[7]; // 인덱스 사용 여부

	public static void main(String[] args) {
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
        int answer = 0;
        
        // 만들고자 하는 문자열 길이
        for(int i=1; i<=numbers.length(); i++) { // 반복문을 통해 1개부터 배열의 크기까지 i개를 뽑는다.
        	String num = "";
        	mix(numbers, num, 0, i);
//        	mix2(numbers, 0, i);
        }
        System.out.println(nums);
        nums.sort(Comparator.naturalOrder());
        
        HashSet<Integer> hashset = new HashSet<Integer>();
        for(int item : nums) {
        	hashset.add(item);
        }
        
        System.out.println(hashset);
        
        for(int n : hashset) {
        	boolean prime = true;
        	if(n == 1 || n == 0) continue;
        	for(int i=2; i<=Math.sqrt(n); i++) {
        		if(n % i == 0) {
        			prime = false;
        			break;
        		}
        	}
        	if(prime || n == 2) {
        		System.out.println("n : "+n);
        		answer += 1;
        	}
        }
        
        return answer;
    }
	
	// 순열
	public static void mix(String numbers, String num, int depth, int r) { // depth는 문자열 길이
		if(depth == r) {
//			String num = "";
//			for(int i=0; i<numbers.length(); i++) {
//				if(visited[i]) {
//					num += numbers.charAt(i);
//				}
//			}
			nums.add(Integer.parseInt(num));
			return;
		}    
		
		for(int i=0; i<numbers.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
//				System.out.println(i+" "+Arrays.toString(visited));
				num += numbers.charAt(i);
//				System.out.println(num);
				mix(numbers, num, depth+1, r);
				if(num.length() >= 2) {
					num = num.substring(0, num.length()-1);
//					System.out.println("# "+num);
				}
				else {
					num = "";
				}
				visited[i] = false;
//				num = "";
			}
		}
	}
	
	// 재귀를 이용한 조합
	public static void mix2(String numbers, int depth, int r) {
		
	}

}
