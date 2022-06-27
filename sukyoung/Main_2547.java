import java.util.*;
import java.math.BigInteger;

public class Main_2547{

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int b;
        
        int a=sc.nextInt();
        for(int i=0; i<a;i++){
            BigInteger sum= new BigInteger("0");
            b=sc.nextInt();
            for( int j=0; j<b; j++){
                sum = sum.add(sc.nextBigInteger());
            
            }
            String p = String.valueOf(sum.remainder(BigInteger.valueOf(b)));
            if (p.equals("0")) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
        
            }
        }
        
    }
}
