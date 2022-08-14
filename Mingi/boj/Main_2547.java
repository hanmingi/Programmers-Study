import java.math.BigInteger;
import java.util.*;
public class Main_2547{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for(int i = 0; i < testcase; i++){
            int stu = sc.nextInt();

            BigInteger sum = new BigInteger("0");

            for(int j = 0; j < stu; j++){
                sum = sum.add(sc.nextBigInteger());
            }

            String reminder = String.valueOf(sum.remainder(BigInteger.valueOf(stu)));

            if(reminder.equals("0")) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}