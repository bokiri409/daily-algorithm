package BOJ;

import java.io.IOException;
import java.util.Scanner;

/*
 * 2022.05.04 daily algo/commit
 * 
 * 실제로 11..1값을 계속 나누게 되면 엄청나게 큰 수를 나눠야 하는 경우도 있기 때문에 
 * 나머지값만을 이용해서 0이되는지만 확인하면 값을 구할 수 있다.!
 */

public class boj_4375 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int num = 0; // 0부터 시작해야 i값이 답이된다. (1부터 시작하면 순서가 틀려짐)
			for(int i=1; ; i++) {
				num = (num%n)*10+1;
				if(num % n == 0) {
//				answer = (int) Math.log10(num)+1; (X) 실제 나누기 계산을 하면 시간초과
					System.out.println(i);
					break;
				}
			}
			
		}
		sc.close();
	}

}
