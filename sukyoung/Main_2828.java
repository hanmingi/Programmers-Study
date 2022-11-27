import java.util.*;


public class Main_2828  {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();  // 스크린칸
        int b=sc.nextInt();  // 바구니길이
        int c=sc.nextInt();  // 사과떨어지는위치개수

        int start=1;  //바구니시작점
        int end=b;    //바구니 끝점
        int answer=0; //총이동거리

        for(int i=0; i<c ; i++){
            int arr[]=new int[c];
            arr[i]=sc.nextInt();
            int p=arr[i];
            //바구니 안
			if(start <= p && p <= end) {
                continue;
			}
			
			//바구니 왼쪽
			if(start > p) {
				answer += (start - p);
				end =end- (start - p);
				start = p;
			}
			
			//바구니 오른쪽
			else{
				answer += (p - end);
				start =start+ (p - end);
				end = p;
            }

        }
        System.out.println(answer);
    }

}
