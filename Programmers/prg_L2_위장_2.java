package Programmers;

/*
 * 2021.11.01 daily algo/commit
 * 
 * ���� �ؽ����� �ƴ� �� �� ������ �ڵ�
 */

import java.util.HashMap;

public class prg_L2_����_2 {
	
	static String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

	public static void main(String[] args) {
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(clothes[0][1], 1);
        for(int i=1; i<clothes.length; i++){
        	String type = clothes[i][1];
            if(map.get(type) == null) { // �ش� ���� ������ ���� ��
            	map.put(type, 1);
            }
            else {
            	int num = map.get(type);
            	map.put(type, num+1); // ���� �߰�
            }
        }
        
        // forEach(���ٹ��)�� �ڵ������ �ٰ� �������� �ö����� for���� �ӵ��� ������ �ܺ� �������� �����ϱⰡ ��������ٴ� ������ �ִ�.
//        map.forEach((key, value) -> {
//        	answer *= (value + 1);
//        });
        
        // �� ���� ���� : ���� ���� + ���Դ� ���(1)
        for(int value : map.values()) {
        	answer *= (value+1);
        }
        
        // �Ǹ��� ���(1)�� ���ش�.
        return answer - 1;
    }

}
