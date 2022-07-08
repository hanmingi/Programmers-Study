import java.util.*;

public class Main_8979 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nation = sc.nextInt();
        int target = sc.nextInt();
        int endpoint = 0;
        int rank = 0;

        int[][] arrs = new int[nation][4];
        
        for(int i = 0; i < nation; i++){
            for(int j = 0; j < 4; j++){
                arrs[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arrs, (o1, o2) -> {
            if(o1[1] == o2[1]){
                if(o1[2] == o2[2]){
                    return Integer.compare(o1[3], o2[3]);
                }
                return Integer.compare(o1[2], o2[2]);
            }
            else{
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        for(int i = 0; i < nation; i++){
            if(arrs[i][0] == target){
                endpoint = i;
                break;
            }
        }

        for(int i = nation - 1; i >= 0; i--){
            if(arrs[i][1] == arrs[endpoint][1] && arrs[i][2] == arrs[endpoint][2] && arrs[i][3] == arrs[endpoint][3]){
                break;
            }
            else rank++;
        }

        System.out.println(rank+1);
    }
}
