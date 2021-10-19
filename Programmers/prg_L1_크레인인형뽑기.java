package Programmers;

import java.util.Stack;

/*
 * 2021.10.19 daily algo/commit
 * 
 * 프로그래머스 2019 카카오 겨울 인턴쉽 기출
 * # 행, 열을 잘 구분할 것.
 * # break의 위치를 정확히 판단할 것
 */

public class prg_L1_크레인인형뽑기 {
	
	static int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
	static int[] moves = {1,5,3,5,1,2,1,4};

	public static void main(String[] args) {
		System.out.println(solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<Integer>();
        for(int i=0; i<moves.length; i++) {
        	for(int j=0; j<board.length; j++) {
        		if(board[j][moves[i]-1] != 0) { // 인형뽑기 기계에 인형이 있을 때
        			if(!basket.isEmpty()) { // 바구니에 인형 있을 때
        				if(basket.peek() == board[j][moves[i]-1]) { // 바구니의 맨 위 인형과 같으면 터트려 사라짐
        					basket.pop();
        					answer += 2;
        				}
        				else { // 같이 않으면 쌓임
        					basket.add(board[j][moves[i]-1]);
        				}
        			}
        			else { // 없을 때
        				basket.add(board[j][moves[i]-1]);
        			}
        			board[j][moves[i]-1] = 0; // 빈 칸으로 만들어 주기 
        			break; // 한 번 뽑으면 다음으로 넘어가기
        		}
        	}
        }
        
        return answer;
    }

}
