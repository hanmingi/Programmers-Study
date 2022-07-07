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
            if(o1[1] == o2[1]){										//금의 개수가 같으면
                if(o1[2] == o2[2]){									//은의 개수가 같으면
                    return Integer.compare(o1[3], o2[3]);			//동의 개수 비교
                }
                return Integer.compare(o1[2], o2[2]);				//은의 개수 비교
            }
            else{
                return Integer.compare(o1[1], o2[1]);				//금의 개수 비교
            }                                                       // 금,동,은 갯수가 많은것이 맨뒤로감
        });
        
        for(int i = 0; i < nation; i++){
            if(arrs[i][0] == target){					//target으로 받은 국가를 endpoint에 넣기
                endpoint = i;
                break;
            }
        }

        for(int i = nation - 1; i >= 0; i--){
            if(arrs[i][1] == arrs[endpoint][1] && arrs[i][2] == arrs[endpoint][2] && arrs[i][3] == arrs[endpoint][3]){
                break;
            }                       //뒤에서 부터 비교를 하면서 같으면 끝내지만 다르면 등수를 하나씩 추가
            else rank++;
        }

        System.out.println(rank+1);
    }
}