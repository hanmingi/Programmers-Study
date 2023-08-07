/**
 * <알고리즘 스터디 27회차 2023.01.25>
 *  LV2_프린터 계산 : https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java
 * 프린터
문제 설명
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
입출력 예
priorities	location	return
[2, 1, 3, 2]	2	1
[1, 1, 9, 1, 1, 1]	0	5
입출력 예 설명
예제 #1

문제에 나온 예와 같습니다.

예제 #2

6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.



출력순서 

문제 : 내가 인쇄를 요청한 문서가 몇번째로 인쇄되는지?
ㄴ> 인쇄할때마다 COUNT ++
ㄴ> location은 0부터시작
ㄴ> 최초위치는 어떻게 저장할지?

 */

package LV2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Printer {
    public int solution222(int[] priorities, int location) {
        
        int answer = 1;
        int myPrint = priorities[location];     //ex : 3
        //스택 선언
        Stack<Integer> priorStack = new Stack<>();        
        // Collections.sort(priorities,Collections.reverseOrder());        //내림차순

        // // //내림차순 정렬
        //  Integer[] arr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        // // int형배열 -> Intger배열로 boxing, (Primitive 자료형 -> Wrapper클래스)
		// Arrays.sort(arr, Collections.reverseOrder());   //Arrays로 정렬

        int arr[] = priorities;        
        Arrays.sort(arr);       //오름차순 정렬
               
        
        //스택 입력
        for(int i = 0 ; i<arr.length; i++){
            priorStack.push(arr[i]);                //ex 2,1,3,2 -> 1,2,2,3
        }   
        
        //스택이 없어질때까지(대기열 사라질때까지 반복)
        while(!priorStack.isEmpty()){
            //출력값과 일치되는 경우 탐색
            for(int i : priorities){
                System.out.println("최상위 스택(Peek) : " + priorStack.peek());
                System.out.println("내출력물(myprint) : " + myPrint);
                if(priorStack.peek() == myPrint){
                    return answer;
                }
                else{
                    priorStack.pop();
                    answer++;
                }
                
                //값이 일치하는경우 해당문서 출력
                // if(priorStack.peek() == priorities[i]){
                    
                    // priorStack.pop();
                    // answer++;
                    // //값이랑 위치가 모두 일치하면 자기문서 반환
                    // if(location == i)
                    //     break;
            }
     
     
        }
        
        return answer;
    }




    //우선순위 큐활용
    public int solution(int[] priorities, int location) {
        
        /**
         * 높은숫자가 우선순위인 int형 우선순위 큐 선언 
         * 메소드
         * add() : 값추가, 예외경우 에러발생
         * offer() : 값추가, 성공시 true, 실패시 false
         * poll() : 첫번째 값을 반환하고 제거, 비어있으면 null
         * remove() : 첫번째 값 제거 비어있으면 예외처리
         * peek() : 첫번쨰값 반환(비어있으면 null)
         * element() : 첫번째값 반환(비어있으면 예외발생), 
         * clear() : 초기화
        */
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        //큐 입력
        for(int i : priorities){
            priorityQueue.offer(i);
        }

        //대기목록 없을떄까지반복
        while(!priorityQueue.isEmpty()){
            //우선순위 배열 탐색
            for(int i = 0 ; i<priorities.length ; i++){
                //값만 일치하는경우 해당문서 출력
                if(priorityQueue.peek() == priorities[i]){
                    priorityQueue.poll();
                    answer++;
                    //우선순위 값 + 위치가 모두 일치할경우 정답반환
                    if(location == i ){
                        return answer;
                    }
                }
            }
        }       
        return answer;
        
    }
    
}
