//package develope;

import java.util.*;

public class Main_2110 {
    static int[] house;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        house = new int[n];
        
        for(int i = 0; i < n; i++){
            house[i] = sc.nextInt();
        }
        
        // 이분 탐색을 하기  위해선 반드시 정렬이 되어 있어야 한다.
        Arrays.sort(house);
        
        // 집 사이의 최소 거리
        int left = 1;
        // 집 사이의 최대 거리
        int right = house[n - 1] - house[0] + 1;
        
        while(left < right){
            int mid = (left + right) / 2;
            
            if(checkInstall(mid) < m){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
    
    public static int checkInstall(int distance){
        int count = 1;
        int lastLocate = house[0];
        
        for(int i = 0; i < house.length; i++){
            int locate = house[i];
            
            if(locate - lastLocate >= distance){
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
