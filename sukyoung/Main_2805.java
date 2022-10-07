import java.util.Scanner;
 
public class Main_2805 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int min = 0;
		int max = 0;
		int x =sc.nextInt();
		int y =sc.nextInt();
		int[] p = new int[y];
		
		for(int i = 0; i<x; i++) {
			p[i] = sc.nextInt();
			if(max < p[i]) {
				max = p[i];   //젤큰 나무 max
			}
		}
		while(min < max) {
			
			int mid = (min + max) / 2;
			long sum = 0;
			for(int treeHeight:p) {
				if(treeHeight - mid>0) { 
					sum=sum+(treeHeight -mid);
				}
			}
			if(sum <y) {
				max=mid;
			}
			else {
				min=mid+1;
			}
		}
		System.out.println(min-1);
		
	}
}