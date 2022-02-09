package Programmers;

import java.util.Stack;

/*
 * 2021.02.09 daily algo/commit
 * 
 * LinkedList ������� �ʰ� stack�� ���� index�� �̿��Ͽ� Ǯ��
 * ���� : https://velog.io/@yuiopre98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-level-3-%ED%91%9C-%ED%8E%B8%EC%A7%91
 */

public class prg_L3_ǥ����3 {
	
	static int n = 8;
	static int k = 2;
//	static String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
	static String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

	public static void main(String[] args) {
		System.out.println(solution(n, k, cmd));
//		String a = "012345";
//		System.out.println(Integer.parseInt(a.substring(3))-1);
	}

	public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> dels = new Stack<Integer>();
        int size = n;
        for(int i=0; i<cmd.length; i++) {
        	if(cmd[i].charAt(0) == 'U') {
        		k -= Integer.parseInt(cmd[i].substring(2));
        	}
        	else if(cmd[i].charAt(0) == 'D') {
        		k += Integer.parseInt(cmd[i].substring(2));
        	}
        	// ������ ����
        	else if(cmd[i].charAt(0) == 'C') {
        		dels.add(k);
        		size--;
        		// ������ ���� ��
        		if(k == size) {
        			k--;
        		}
        	}
        	// ������ ����
        	else {
        		if(dels.pop() <= k) {
        			k++;
        		}
        		size++;
        	}
        }
        boolean[] data = new boolean[n];
        while(!dels.isEmpty()) {
        	data[dels.pop()] = true; // ������ ������
        }
        String answer = "";
        for(int i=0; i<data.length; i++) {
        	if(!data[i]) answer += "O";
        	else answer += "X";
        }
        return answer;
    }
}
