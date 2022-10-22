//package develope;

import java.util.*;

public class Main_5710 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 0 && b == 0) return;

            int total = cal(a);
            int min = 0;
            int max = total / 2;
            
            while(min <= max){
                int mid = (min + max) / 2;

                int s_man = cal_p(mid);
                int n_man = cal_p(total - mid);

                int diff = Math.abs(s_man - n_man);

                if(diff < b){
                    max = mid - 1;
                }
                else if(diff > b){
                    min = mid + 1;
                }
                else{
                    System.out.println(cal_p(mid));
                    break;
                }
            }
        }
    }

    public static int cal(int price){
        if(price <= 200) return price / 2;
        else if(price <= 29900) return (price - 200) / 3 + 100;
        else if(price <= 4979900) return (price - 29900) / 5 + 10000;
        else return (price - 4979900) / 7 + 1000000;
    }

    public static int cal_p(int m){
        if(m <= 100) return m * 2;
        else if(m <= 10000) return 200 + (m - 100) * 3;
        else if(m <= 1000000) return 200 + 29700 + (m - 10000) * 5;
        else return 200 + 29700 + 4950000 + (m - 1000000) * 7; 
    }
}
