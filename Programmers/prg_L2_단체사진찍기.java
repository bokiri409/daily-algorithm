package Programmers;

/*
 * 2021.09.09 daily algo/commit
 * 
 * DFS - ��Ž���� ��ü Ȯ���� �� ���ǿ� �´� ���� ����
 */

public class prg_L2_��ü������� {
	
	static int n = 2;
	static String[] data = {"N~F=0", "R~T>2"};
//	static String[] data = {"M~C<2", "C~M>1"};
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static boolean[] visited = new boolean[8];
	static String picture = "";
	static int answer = 0;

	public static void main(String[] args) {
		System.out.println(solution(n, data));
	}
	
	public static int solution(int n, String[] data) {
		answer = 0;
        dfs(data);
        return answer;
    }
	
	private static void dfs(String[] data) {
		if(picture.length() == 8) { // ��� �� ������ �� ����
			if(check(data, picture)) {
				answer++;
			}
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				picture += friends[i];
				dfs(data);
				visited[i] = false; // ���ƿ� �� �湮üũ ����
				picture = picture.substring(0, picture.length()-1); // �ܾ� �߰��� ����
			}
		}
	}

	private static boolean check(String[] data, String picture) {
		for(String datum : data) {
			int f1 = picture.indexOf(datum.charAt(0)); //������ 1
			int f2 = picture.indexOf(datum.charAt(2)); //������ 2
			
			char op = datum.charAt(3); // ���
			int distance = datum.charAt(4) - '0';
			
			if(op == '=') { // ���� �� 
				if(Math.abs(f1-f2) != distance+1) return false;
			}
			else if(op == '<') {
				if(Math.abs(f1-f2) >= distance+1) return false;
			}
			else {
				if(Math.abs(f1-f2) <= distance+1) return false;
			}
		}
		return true;
	}
}
