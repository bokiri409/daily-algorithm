package Programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 2021.09.24 daily algo/commit
 * 
 * ���α׷��ӽ� - �ؽ�
 * �ǻ�(Ű)���� ���� Ȯ�� �� �����ֱ�
 * (�ǻ󰳼�1+1)*(�ǻ󰳼�2+1)... -1
 * +1 : �ǻ󰳼��� ���Դ� ���, -1 : ��ü �ƹ��͵� ���Դ� ��� 1����(�ּ� �ϳ� �̻��� �Ծ�� ��)
 */

public class prg_L2_���� {
	
	// 1~30��
	static String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

	public static void main(String[] args) {
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        Map<String, ArrayList<String>> clothing = new HashMap<String, ArrayList<String>>();
        ArrayList<String> details;
        
        for(int i=0; i<clothes.length; i++) {
        	if(clothing.containsKey(clothes[i][1])) { // �ʿ� �����ϴ� Ű���
        		clothing.get(clothes[i][1]).add(clothes[i][0]);
        	}
        	else {
        		details = new ArrayList<String>(); // ���ο� List ����
        		details.add(clothes[i][0]);
        		clothing.put(clothes[i][1], details);
        	}
        }
        
//        Set<String> keys = clothing.keySet(); // ���� Ű ���� 
        Collection<ArrayList<String>> values = clothing.values(); // ���� value����
        Iterator<ArrayList<String>> iter = values.iterator();
        int answer = 1;
        while(iter.hasNext()) {
        	int value = iter.next().size();
        	answer *= value+1;
        }
        
        return answer-1;
    }

}
