import java.util.*;

public class Main_1063 {

    static char[] k;
    static char[] s;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String King = sc.next();
        String Stone = sc.next();
        int times = sc.nextInt();

        k = King.toCharArray();
        s = Stone.toCharArray();
        
        //System.out.println((char)(k[0] + 1));

        for(int i = 0; i < times; i++){
            String move = sc.next();
            
            checkQ(move);
        }

        System.out.print(k[0]);
        System.out.print(k[1]);
        System.out.println();
        System.out.print(s[0]);
        System.out.print(s[1]);
    }

    // check king, stone position
    static void checkQ(String move){
        //k_temp[0] : a, b, c, d, e, f, g, h (width)
        //k_temp[1] : 1, 2, 3, 4, 5, 6, 7, 8 (height)

        char[] k_temp = k.clone();
        char[] s_temp = s.clone();

        switch(move){
            case "R": 
                k_temp[0] += 1;
                s_temp[0] += 1;
                break;

            case "L":
                k_temp[0] -= 1;
                s_temp[0] -= 1;
                break;

            case "B":
                k_temp[1] -= 1;
                s_temp[1] -= 1;    
                break;

            case "T":
                k_temp[1] += 1;
                s_temp[1] += 1; 
                break;

            case "RT":
                k_temp[0] += 1;
                s_temp[0] += 1;
                k_temp[1] += 1;
                s_temp[1] += 1; 
                break;

            case "LT":
                k_temp[0] -= 1;
                s_temp[0] -= 1;
                k_temp[1] += 1;
                s_temp[1] += 1; 
                break;

            case "RB":
                k_temp[0] += 1;
                s_temp[0] += 1;
                k_temp[1] -= 1;
                s_temp[1] -= 1; 
                break;

            case "LB":
                k_temp[0] -= 1;
                s_temp[0] -= 1;
                k_temp[1] -= 1;
                s_temp[1] -= 1; 
                break;
        }

        if(k_temp[0] >= 'A' && k_temp[0] <= 'H' && k_temp[1] >= '1' && k_temp[1] <= '8'){
            if(k_temp[0] == s[0] && k_temp[1] == s[1]) {
                if(s_temp[0] >= 'A' && s_temp[0] <= 'H' && s_temp[1] >= '1' && s_temp[1] <= '8'){
                    s = s_temp.clone();
                    k = k_temp.clone();
                }
            }
            else{
                k = k_temp.clone();
            }
        }
    }
}
