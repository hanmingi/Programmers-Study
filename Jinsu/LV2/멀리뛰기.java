
/**
 * 28회차 알고리즘 스터디 : 23.02.02
 * LV2_멀리 뛰기 : https://school.programmers.co.kr/learn/courses/30/lessons/12914
 * 문제 설명
효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 
칸이 총 4개 있을 때, 효진이는
(1칸, 1칸, 1칸, 1칸)
(1칸, 2칸, 1칸)
(1칸, 1칸, 2칸)
(2칸, 1칸, 1칸)
(2칸, 2칸)
의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 
효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 
여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 
예를 들어 4가 입력된다면, 5를 return하면 됩니다.

제한 사항
n은 1 이상, 2000 이하인 정수입니다.
입출력 예
n	result
4	5
3	3
입출력 예 설명
입출력 예 #1
위에서 설명한 내용과 같습니다.

입출력 예 #2
(2칸, 1칸)
(1칸, 2칸)
(1칸, 1칸, 1칸)
총 3가지 방법으로 멀리 뛸 수 있습니다.
 * 
 */
/**
 * 경우의수 1,2,3,5,8,...
 * -> 피보나치 수열
 * Fn = F(n-1) + F(n-2)
 * ㄴ> 문제에서 요구하는 경우의 갯수
 */
package LV2;

public class longJump {
    public long solution(int n) {

        if(n<=1) return n;  //n이 1보다 작을 때에는 값 반환
        else{
            long answer = 0;
            long A = 0;         //(n-2)
            long B = 1;         //(n-1)

            for(int i = 0 ; i<n+1; i++){
                System.out.println("answer : " + answer);
                System.out.println("A : " + A);
                System.out.println("B : " + B);
                answer = A + B;
                A = B;
                B = answer;
            }
            System.out.println("answer :" + answer);
            System.out.println("answer % 1234567 : " + answer%1234567);
            return answer%1234567;
        }
    }


    //시간초과!
    public long solution2(int n) {
        long answer = 0;
        int test = fibonacci_rsv(n+1);
        System.out.println(test);
        answer = (long) (test % 1234567);
        return answer;
    }
    
    public int fibonacci_rsv(int n){
        if(n <= 1) return n;
        else return fibonacci_rsv(n-2) + fibonacci_rsv(n-1);
    }


    //시간초과!
    public long solution3(int n) {
        long answer = 0;
        int test = fibonacci_rsv2(n+1);
        System.out.println(test);
        answer = (long) (test);
        return answer;
    }
    
    public int fibonacci_rsv2(int n){
        if(n <= 1) return n;
        else return (fibonacci_rsv2(n-2) + fibonacci_rsv2(n-1)) %1234567;
    }


    //최종답안!!
    //결과값 나머지를 미리 구함? 
    public long solution4(int n) {        

        if(n<=1) return n;  //n이 1보다 작을 때에는 값 반환
        else{
            long answer = 0;
            long A = 0;             
            long B = 1;         

            for(int i = 2 ; i<=n; i++){                
                answer = (A + B) % 1234567;
                A = B;
                B = answer;
            }            
            return answer;
        }
    }


}
