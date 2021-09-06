package Programmers;

/*
 * 2021.09.06 daily algo/commit
 */

public class prg_week6_복서정렬하기 {
	
	static int[] weights = {50,82,75,120};
	static String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

	public static void main(String[] args) {
		solution(weights, head2head);
	}
	
	public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        double[] rank = new double[weights.length]; // 승률
        int[] plus = new int[weights.length]; // 더 무거운 복서 이긴 횟수
        
//        for(int i=0; i<weights.length; i++) {
//        	checkRank(weights, head2head[i], i, rank);
//        }
        
        for(int i=0; i<head2head.length; i++) {
        	double win = 0;
        	double lose = 0;
        	for(int j=0; j<head2head[i].length(); j++) {
        		if (head2head[i].charAt(j) == 'W') {
        			win += 1;
        			if(weights[i] < weights[j]) { // 내가 몸무게가 더 적게 나갈 때
        				plus[i] += 1;
        			}
        		}
        		else if(head2head[i].charAt(j) == 'L') {
        			lose += 1;
        		}
        	}
        	if(lose+win == 0) {
        		rank[i] = 0;
        	}
        	else {
        		rank[i] = win/(lose+win);
        	}
		}
        
        for(int i=0; i<answer.length; i++) {
        	double max = rank[0];
        	int max2 = plus[0];
        	int weight = weights[0];
        	int idx = 0;
        	for(int j=1; j<rank.length; j++) {
        		if(max < rank[j]) { // rank[j][0]가 더 클 때
        			max = rank[j];
        			max2 = plus[j];
        			weight = weights[j];
        			idx = j;
        			continue;
        		}
        		else if(max == rank[j]) { // 이긴 횟수가 같을 때
        			if(max2 < plus[j]) { // 추가 점수가 더 크면
        				max = rank[j];
        				max2 = plus[j];
        				weight = weights[j];
        				idx = j;
        				continue;
        			}
        			else if(max2 == plus[j]){ // 추가 점수도 같으면
        				if(weight < weights[j]) {
        					max = rank[j];
            				max2 = plus[j];
            				weight = weights[j];
            				idx = j;
            				continue;
        				}
        			}
        		}
        	}
        	
        	answer[i] = idx+1;
        	rank[idx] = -1;
        }
        
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
	
//	private static void checkRank(int[] weights, String head2head, int num, int[][] rank) {
//		for(int i=0; i<head2head.length(); i++) {
//			if (head2head.charAt(i) == 'W') {
//				if(weights[num] < weights[i]) { // 내가 몸무게가 더 적게 나갈 때
//					rank[num][0] += 1;
//					rank[num][1] += 1;
//				}
//				else {
//					rank[num][0] += 1;
//				}
//			}
//		}
//	}

}
