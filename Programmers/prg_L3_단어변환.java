package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.08.30 daily algo/commit
 * 
 * DFS�� ������ ��� Ž���� ���� �켱���� Ž���ϱ� ������ 
 * BFS�� Ȱ���Ͽ� ���� ���̰� ���� Ž������ �ϰ� ���� ã���� Ž���� ��ġ���� �Ѵ�.
 * => visited�� �湮 üũ�� �Ѵ�. ������ �ִ� depth�� ã�� �ű� ������ ��� ���� �� �ʿ䰡 ����.
 * 
 * ���� : https://real-012.tistory.com/202
 */

public class prg_L3_�ܾȯ {
	
	static String begin = "hit";
	static String target = "cog";
	static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
	static boolean[] visited;

	public static void main(String[] args) {
		System.out.println(solution(begin, target, words));
	}
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(checked(target, words)) { // words�ȿ� ������ ��
        	answer = bfs(begin, target, words);
        }
        else {
        	answer = 0;
        }
        
        return answer;
    }
	
	static boolean checked(String target, String[] words) {
		for(int i=0; i<words.length; i++) {
			if(target.equals(words[i])) { // �����ϸ� true ��ȯ
				return true;
			}
		}
		return false;
	}
	
	private static int bfs(String begin, String target, String[] words) {
		Queue<Word> q = new LinkedList<Word>();
		visited = new boolean[words.length];
		
		q.offer(new Word(begin, 0));
		while(!q.isEmpty()) {
			Word curWord = q.poll();
			
			for(int i=0; i<words.length; i++) {
				if(!visited[i]) {
					int cnt = 0;
					for(int j=0; j<words[i].length(); j++) {
						if(curWord.word.charAt(j) != words[i].charAt(j)) {
							cnt++;
							if(cnt > 1) break; // �ٸ� ���ĺ��� 2�� �̻��� ��
						}
					}
					if(cnt == 1) {  // �ܾ� ��ȯ ������ ��
						if(words[i].equals(target)) {
							return curWord.depth+1;
						}
						q.offer(new Word(words[i], curWord.depth+1));
						visited[i] = true;
					}
				}
				
			}
		}
		return 0;
	}
	
	private static class Word{
		String word;
		int depth;
		
		Word(String word, int depth){
			this.word = word;
			this.depth = depth;
		}
	}
	
}
