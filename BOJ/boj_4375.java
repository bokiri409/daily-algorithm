package BOJ;

import java.io.IOException;
import java.util.Scanner;

/*
 * 2022.05.04 daily algo/commit
 * 
 * ������ 11..1���� ��� ������ �Ǹ� ��û���� ū ���� ������ �ϴ� ��쵵 �ֱ� ������ 
 * ������������ �̿��ؼ� 0�̵Ǵ����� Ȯ���ϸ� ���� ���� �� �ִ�.!
 */

public class boj_4375 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int num = 0; // 0���� �����ؾ� i���� ���̵ȴ�. (1���� �����ϸ� ������ Ʋ����)
			for(int i=1; ; i++) {
				num = (num%n)*10+1;
				if(num % n == 0) {
//				answer = (int) Math.log10(num)+1; (X) ���� ������ ����� �ϸ� �ð��ʰ�
					System.out.println(i);
					break;
				}
			}
			
		}
		sc.close();
	}

}
