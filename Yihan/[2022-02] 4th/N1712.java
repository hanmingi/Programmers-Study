package FEB_4th;

import java.util.Scanner;

public class N1712 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
 
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
        
		if (C <= B) {
			System.out.println("-1");
		} 
		else {
			System.out.println((A/(C-B))+1);
		}
	}
}