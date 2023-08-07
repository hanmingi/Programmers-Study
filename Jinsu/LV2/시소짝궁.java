/**
 * * <알고리즘 스터디 30회차 2023.02.16>
 *  LV2_시소짝궁 : https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 문제 설명
어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다. 즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
사람들의 몸무게 목록 weights이 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.

제한 사항
2 ≤ weights의 길이 ≤ 100,000
100 ≤ weights[i] ≤ 1,000
몸무게 단위는 N(뉴턴)으로 주어집니다.
몸무게는 모두 정수입니다.
입출력 예
weights	result
[100,180,360,100,270]	4
입출력 예 설명
{100, 100} 은 서로 같은 거리에 마주보고 앉으면 균형을 이룹니다.
{180, 360} 은 각각 4(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
{180, 270} 은 각각 3(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
{270, 360} 은 각각 4(m), 3(m) 거리에 마주보고 앉으면 균형을 이룹니다.
 */


package LV2;

import java.util.Arrays;
import java.util.HashMap;

public class SisoFriend {
    //경우의수를 다떄려넣어보자
    // 테스트케이스 10,11만 시간초과, -> 로직에는 문제가없음!
    //  ㄴ> 중복값 제거로직 추가 -> 테스트케이스 10,11,13,14,15 시간초과???? 계산하는데 더오래걸리는듯...
    //  ㄴ> 정렬후 경우의수 A<B가 참인것만 비교
    //  ㄴ> ★★Full scan말고 이진탐색 조건 추가 -> 아슬아슬하게 통과!
    
    
    //정답본
    public long solution(int[] weights) {
        // HashMap<Integer,Integer> dupDel = new HashMap<>();   //값,개수        
        // long dup = 0;

        //중복 몸무게 조합 확인용       -> 오래걸리는듯?
        // for(int i = 0 ; i < weights.length ; i++){
        //     dupDel.put(weights[i], dupDel.getOrDefault(weights[i], 0) + 1);
        // }      
        // for(int i : dupDel.keySet()){
        //     if(dupDel.get(i) > 1){
        //         long n = dupDel.get(i);                  
        //         dup += (n * (n-1)) / 2;                
        //     }
        // }


        long answer = 0;
        //정렬      -> a <= b 가 무조건 참
        Arrays.sort(weights);

        for(int i = 0; i < weights.length - 1; i++){
            for(int j = i+1; j < weights.length && weights[i]*2 >= weights[j]; j++){                
                //같을떄
                if(weights[i] == weights[j]){
                    answer++;
                    // continue;
                }
                // //2:3
                // else if(weights[i]*2 == weights[j]*3){
                //     answer++;
                // }
                //2:4 
                // else if(weights[i]*2 == weights[j]*4){
                //     answer++;
                // }
                //3:2
                else if(weights[i]*3 == weights[j]*2){
                    answer++;
                }   
                // //3:4            
                // else if(weights[i]*3 == weights[j]*4){
                //     answer++;
                // }
                //4:2 -> 2:1로 변경, 숫자크기 줄이기
                else if(weights[i]*2 == weights[j]*1){
                    answer++;
                }
                //4:3
                else if(weights[i]*4 == weights[j]*3){
                    answer++;
                }               
            }
        }
        return answer;
    }

    /*
    ************************************************************************************* */


    // public long solution_old(int[] weights) {
    //     HashMap<Integer,Integer> dupDel = new HashMap<>();   //값,개수
    //     long answer = 0;

    //     //중복제거
    //     for(int i = 0 ; i < weights.length ; i++){
    //         dupDel.put(weights[i], dupDel.getOrDefault(weights[i], 0) + 1);
    //     }        

    //     int test = 0;
    //     for(int i : dupDel.keySet()){
    //         System.out.println("dupDel.KeySet : " + dupDel.keySet());
    //         if(dupDel.get(i) > 1){
    //             test++;
    //         }
    //     }
    //     answer = test % 2;
        
    //     Integer[] arr = dupDel.keySet().toArray(new Integer[dupDel.size()]);

        

    //     HashMap<Long,Long> sisoFriend = new HashMap<>();   //값,개수

    //     long twice;
    //     long third;
    //     long fourth;
        
    //     for(int i = 0; i< arr.length; i++){     //100,180,360,100,270
    //         // subArrMap.put(sum, subArrMap.getOrDefault(subArrMap.get(sum), 0) + 1);
    //         twice = 2 * arr[i];
    //         third = 3 * arr[i];
    //         fourth = 4 * arr[i];
            
    //         // sisoFriend.put(arr[i], sisoFriend.getOrDefault(arr[i], 0) + 1);
    //         // System.out.println(sisoFriend.get(weights[i]));
    //         sisoFriend.put(twice, sisoFriend.getOrDefault(twice, (long) 0) + 1);
    //         sisoFriend.put(third, sisoFriend.getOrDefault(third, (long) 0) + 1);
    //         sisoFriend.put(fourth, sisoFriend.getOrDefault(fourth, (long) 0) + 1);           
    //     }
        
    //     for (Long i : sisoFriend.keySet()){
    //         System.out.print(i + "   ");
    //         System.out.println(sisoFriend.get(i));
    //         if(sisoFriend.get(i) > 1){                
    //             answer++;
    //         }
    //     }
        
    //     return answer;
    // }

    // public long solution_wewe(int[] weights) {
    //     HashMap<Integer,Integer> dupDel = new HashMap<>();   //값,개수
    //     long answer = 0;
    //     int dup = 0;

    //     //중복 몸무게 조합 확인용
    //     for(int i = 0 ; i < weights.length ; i++){
    //         dupDel.put(weights[i], dupDel.getOrDefault(weights[i], 0) + 1);
    //     }        

        
    //     for(int i : dupDel.keySet()){
    //         // System.out.println("dupDel.KeySet : " + dupDel.keySet());

    //         //몸무게가 같은사람이 2명이상일경우 만들수 있는조합 계산
    //         //n명중 2개를 순서X 조합 -> nC2 -> (n! / (n-2)! * 2!) -> n*(n-1) / 2
            
    //         if(dupDel.get(i) > 1){
    //             int n = dupDel.get(i);                
    //             // test++;
    //             dup += (n * (n-1)) / 2;
                
    //         }            
    //     }
        
    //     Integer[] arr = dupDel.keySet().toArray(new Integer[dupDel.size()]);

    //     // for(int i = 0 ; i < weights.length-1; i++){
    //     //     int tmp =0;
    //     //     for(int j = i+1 ; j<weights.length; j++){
    //     //         // if(
    //     //         //     arr[i]   == arr[j] || 
    //     //         //     arr[i]*2 == arr[j]*3 ||
    //     //         //     arr[i]*2 == arr[j]*4 ||
    //     //         //     arr[i]*3 == arr[j]*2 ||
    //     //         //     arr[i]*3 == arr[j]*4 ||
    //     //         //     arr[i]*4 == arr[j]*2 ||
    //     //         //     arr[i]*4 == arr[j]*3
    //     //         // ){
    //     //         if(
    //     //             // weights[i]   == weights[j] || 
    //     //             weights[i]*2 == weights[j]*3 ||
    //     //             weights[i]*2 == weights[j]*4 ||
    //     //             weights[i]*3 == weights[j]*2 ||
    //     //             weights[i]*3 == weights[j]*4 ||
    //     //             weights[i]*4 == weights[j]*2 ||
    //     //             weights[i]*4 == weights[j]*3
    //     //         )
    //     //         {
    //     //             tmp++;
    //     //         }

    //     //     }
    //     //     answer += tmp;            
    //     // }

    //     for(int i = 0 ; i < arr.length-1; i++){
    //         int tmp =0;
    //         for(int j = i+1 ; j<arr.length; j++){
    //             if(
    //                 arr[i]   == arr[j] || 
    //                 arr[i]*2 == arr[j]*3 ||
    //                 arr[i]*2 == arr[j]*4 ||
    //                 arr[i]*3 == arr[j]*2 ||
    //                 arr[i]*3 == arr[j]*4 ||
    //                 arr[i]*4 == arr[j]*2 ||
    //                 arr[i]*4 == arr[j]*3
    //             )
    //             {
    //                 tmp++;
    //             }

    //         }
    //         answer += tmp;            
    //     }



    //     System.out.println("answer ; " + answer);
    //     System.out.println("중복인원 경우의수 dup : " + dup);

    //     return answer+dup;
    // }

    // //시간초과남    
    // public long solution_oldoldoldoldddodododod(int[] weights) {        
    //     HashMap<Long,Integer> dupDel = new HashMap<>();   //값,개수
    //     long answer = 0;
    //     int dup = 0;

    //     //비율 경우의수        
    //     double ratio[][] = {{2.0,3.0}, {2.0,4.0}, {3.0,2.0}, {3.0,4.0}, {4.0,2.0}, {4.0,3.0}};

    //     //중복 몸무게 조합 확인용
    //     for(int i = 0 ; i < weights.length ; i++){
    //         dupDel.put((long)weights[i], dupDel.getOrDefault((long)weights[i], 0) + 1);
    //     }        

        
    //     for(Long i : dupDel.keySet()){            

    //         //몸무게가 같은사람이 2명이상일경우 만들수 있는조합 계산
    //         //n명중 2개를 순서X 조합 -> nC2 -> (n! / (n-2)! * 2!) -> n*(n-1) / 2            
    //         if(dupDel.get(i) > 1){
    //             int n = dupDel.get(i);  
    //             // test++;
    //             dup += (n * (n-1)) / 2;                
    //         }

            
    //         for(int j = 0 ; j<ratio.length; j++){                
    //             Double ex_W = i * ratio[j][0] / ratio[j][1];
    //             // System.out.println(i + " * " +ratio[j][0] +"/"+ ratio[j][1] );
    //             // System.out.println(i);
    //             // System.out.println(ratio[j][0]+":"+ratio[j][1]);
    //             // System.out.println("ex_W : " + ex_W);                
    //             // System.out.println("-----");

    //             long ex_W_long = Double.valueOf(ex_W).longValue();
    //             //맵에 있으면 경우의수 계산 (x*y)가지
    //             if(dupDel.getOrDefault(ex_W_long,0) != 0){
    //                 dup += dupDel.get(i) * dupDel.get(ex_W_long);
    //             }   
    //         }
    //          dupDel.put(i, 0);

    //     }

    //     return dup;
    // }
}       