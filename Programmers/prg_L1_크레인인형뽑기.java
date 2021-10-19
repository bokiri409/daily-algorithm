package Programmers;

import java.util.Stack;

/*
 * 2021.10.19 daily algo/commit
 * 
 * ���α׷��ӽ� 2019 īī�� �ܿ� ���Ͻ� ����
 * # ��, ���� �� ������ ��.
 * # break�� ��ġ�� ��Ȯ�� �Ǵ��� ��
 */

public class prg_L1_ũ���������̱� {
	
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
        		if(board[j][moves[i]-1] != 0) { // �����̱� ��迡 ������ ���� ��
        			if(!basket.isEmpty()) { // �ٱ��Ͽ� ���� ���� ��
        				if(basket.peek() == board[j][moves[i]-1]) { // �ٱ����� �� �� ������ ������ ��Ʈ�� �����
        					basket.pop();
        					answer += 2;
        				}
        				else { // ���� ������ ����
        					basket.add(board[j][moves[i]-1]);
        				}
        			}
        			else { // ���� ��
        				basket.add(board[j][moves[i]-1]);
        			}
        			board[j][moves[i]-1] = 0; // �� ĭ���� ����� �ֱ� 
        			break; // �� �� ������ �������� �Ѿ��
        		}
        	}
        }
        
        return answer;
    }

}
