/**
 * <알고리즘 스터디 30회차 2023.02.16>
 *  LV2_연속부분수열의합의 개수 : https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 문제 설명
    철호는 수열을 가지고 놀기 좋아합니다. 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지 알아보고 싶어졌습니다. 원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다. 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 다음과 같습니다.
    그림.png
    원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아집니다.
    원형 수열의 모든 원소 elements가 순서대로 주어질 때, 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.

    제한사항
    3 ≤ elements의 길이 ≤ 1,000
    1 ≤ elements의 원소 ≤ 1,000
    입출력 예
    elements	result
    [7,9,1,1,4]	18
    입출력 예 설명
    입출력 예 #1
    길이가 1인 연속 부분 수열로부터 [1, 4, 7, 9] 네 가지의 합이 나올 수 있습니다.
    길이가 2인 연속 부분 수열로부터 [2, 5, 10, 11, 16] 다섯 가지의 합이 나올 수 있습니다.
    길이가 3인 연속 부분 수열로부터 [6, 11, 12, 17, 20] 다섯 가지의 합이 나올 수 있습니다.
    길이가 4인 연속 부분 수열로부터 [13, 15, 18, 21] 네 가지의 합이 나올 수 있습니다.
    길이가 5인 연속 부분 수열로부터 [22] 한 가지의 합이 나올 수 있습니다.
    이들 중 중복되는 값을 제외하면 다음과 같은 18가지의 수들을 얻습니다.
    [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 20, 21, 22]
 */

package LV2;

import java.util.ArrayList;
import java.util.HashMap;

public class ContinuousSeq {     
    public int solution(int[] elements) {        
        //중복체크하기위한 해쉬맵
        HashMap<Integer,Integer> subArrMap = new HashMap<>();   //값,개수

        //배열의 시작위치 
        int front = 0;
        //배열의 길이만큼 반복
        for(int i = 0; i<elements.length ; i++){
            int sum = 0;    //부분수열의 합
            //i가 증가할때마다 배열의 시작위치를 한칸 오른쪽으로 이동시켜준다.
            for(int j = i; j < (i+elements.length) ; j++){                   
                front = j;      //배열의 시작위치

                if(j >= elements.length){       //배열의 범위가 넘어가면 0번으로 초기화
                    front =j-elements.length;
                    // System.out.println("new front : " + front);
                    sum += elements[front]; 
                    System.out.println(" element : " + elements[front]);   
                    System.out.println(" sum : " + sum);   
                }
                else{
                    sum += elements[front];   
                    System.out.println(" element : " + elements[front]);   
                    System.out.println(" sum : " + sum);   
                }                
                //개수 카운팅                          
                subArrMap.put(sum, subArrMap.getOrDefault(subArrMap.get(sum), 0) + 1);
            }                
        }
        System.out.println(subArrMap.keySet());
        return subArrMap.size();    
    }
}