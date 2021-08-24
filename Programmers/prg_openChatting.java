package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2021.08.24 daily algo/commit
 * 
 * ���α׷��ӽ� Level 2 - ����ä�ù�
 * HashMap���� Ǯ� �����ϰ� key������ valueüũ�ؼ� �� �����ϱ�
 * ������ order�� ���� �̸� hashmap�� �ۼ��� �� enter�� leave�� ���ؼ��� ��°��� �����ָ� �ȴ�.
 * 
 * �����ڷ� : https://sublivan.tistory.com/51
 * hashmap�� ���� �ڷ� : https://kkh0977.tistory.com/42
 */

public class prg_openChatting {
	
	static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//	static ArrayList<String[]> userIds = new ArrayList<String[]>();
	static HashMap<String, String> userInfo = new HashMap<String, String>();
	static ArrayList<String> result = new ArrayList<String>();
	
	static String userId;
	static String nickName;

	public static void main(String[] args) {
		System.out.println(solution(record));
	}
	
	public static ArrayList<String> solution(String[] record) {
		StringTokenizer st;
		for(int i=0; i<record.length; i++) {
			st = new StringTokenizer(record[i]);
			String order = st.nextToken();
			userId = st.nextToken();
			
			switch (order) {
			case "Enter": // ���� ��ɾ� �� ��
				nickName = st.nextToken();
				if(!isVisited(userId)) { // �ش� ���̵� �湮 ����� ���ٸ�
//					userIds.add(new String[] {userId, nickName});
					userInfo.put(userId, nickName);
				}
				else { // �湮 ����� �ִٸ�
//					change(userId, nickName);
					userInfo.replace(userId, nickName);
				}
//				result.add(new String[] {nickName+"���� ���Խ��ϴ�.", userId});
				break;
			case "Leave":
//				result.add(new String[] {leave(userId)+"���� �������ϴ�.", userId});
//				result.add(new String[] {userInfo.get(userId)+"���� �������ϴ�.", userId});
				break;
			case "Change":
				nickName = st.nextToken();
//				change(userId, nickName);
				userInfo.replace(userId, nickName);
				break;
			}
		}
		
		for(int i=0; i<record.length; i++) {
			st = new StringTokenizer(record[i]);
			String order = st.nextToken();
			String id = st.nextToken();
			if(order.equals("Enter")) {
				result.add(userInfo.get(id) + "���� ���Խ��ϴ�.");
			}
			if(order.equals("Leave")) {
				result.add(userInfo.get(id) + "���� �������ϴ�.");
			}
		}
		
//		String[] answer = new String[result.size()];
//		for(int j=0; j<answer.length; j++) {
//			answer[j] = result.get(j)[0];
//		}
		
        return result;
    }
	
	private static boolean isVisited(String id) { // �湮 ���� �˻�
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) { // ���̵� �湮 ���� ��
//				return true;
//			}
//		}
		if(userInfo.containsKey(id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	private static String leave(String id) {
//		String name = null;
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) {
//				name = userIds.get(i)[1]; // �ش� ���̵��� �г���
//				break;
//			}
//		}
//		return userInfo.get(id);
//	}
	
//	private static void change(String id, String newNickName) {
//		
//		
//		String oldNickName = "";
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) {
//				oldNickName = userIds.get(i)[1];
//				userIds.get(i)[1] = newNickName; // �г��� ����
//				break;
//			}
//		}
//		
//		for(int i=0; i<result.size(); i++) {
//			if(result.get(i)[1].equals(id)) {
//				result.get(i)[0] = result.get(i)[0].replace(oldNickName, newNickName);
//			}
//		}
		
//		String name = null;
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) {
//				name = userIds.get(i)[1]; // �ش� ���̵��� �г���
////				userIds.set(i, userIds.get(i)[1].replaceAll(".", nickname));
//				userIds.get(i)[1] = nickname;
//				return name;
//			}
//		}
//		return "0"; // ���� ���� ��
//	}

}
