import java.util.Scanner;
public class Main_11687 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int min=1;
        int max=p*5;
 
        boolean answer=false;
        while(min<=max){
            int mid = (min+max)/2;
            int count=0;
 
            for(int i=5; i<=mid; i=i*5){
            count=count+(mid/i);
            }
            if(count>p){
                max=mid-1;
            } else if(count==p){
                max=mid-1;
                answer=true;
            }
            else{
                min = mid+1;
            }
        }
        if(answer){
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}