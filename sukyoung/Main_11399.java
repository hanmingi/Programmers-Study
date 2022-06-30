import java.util.*;


public class Main_11399{

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        
        int N=sc.nextInt();

        int []arr=new int[N];

        for(int i=0; i<N;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        
        int sum=0;
        int b=0;

        for(int j=0; j<N;j++){
            

            sum += b+arr[j];
            b += arr[j];
        }
        System.out.println(sum);
    }
}
