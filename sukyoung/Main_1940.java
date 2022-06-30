import java.util.*;

public class Main_1940{

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        
        int N=sc.nextInt();
        int M=sc.nextInt();
        int count=0;

        int arr[]=new int[N];
        
        for(int i=0; i<N;i++){
            arr[i]=sc.nextInt();
        }

        for(int i =0;i<N-1;i++){
            for(int j=i+1; j<N;j++){
                if(M==arr[i]+arr[j]){
                    count++;
                }
                
            }
        }
        System.out.println(count);
        
    }
}
