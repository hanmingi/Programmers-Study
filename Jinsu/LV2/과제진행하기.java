package LV2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * <알고리즘 스터디 46회차 2023.06.15>
 *  LV2 과제진행하기 : https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */

public class AssignmentProgress {


    // 우선순위큐 사용하기위해 Comparable 인터페이스 상속
    // Comparable 관련 정의  : https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#method.summary
    public class Plan implements Comparable<Plan>
    {
        String name;
        int start;
        int playtime;

        /**생성자 */
        public Plan(String name, int start, int playtime)
        {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        //우선순위큐를 Plan클래스로 사용하기위해 compareTo메소드 오버라이딩
        @Override
        public int compareTo(Plan target)
        {
            System.out.println("comapreTo");
            return this.start >= target.start ? 1 : - 1;    //시작시간이 작은 순으로 정렬
        }
    }

    public String[] solution(String[][] plans) {
        
        // 정답을 저장할 리스트
        List<String> answer = new ArrayList<>();

        // Stack<HashMap<String,Integer>> stopStack = new Stack<>(); -> 해쉬맵이 아닌 클래스로 관리
        Stack<Plan> stopStack = new Stack<>();

        //-> 문제에서 주어진 시간이 정렬되지 않을수도 있다고 명시했음, 우선순위 큐로 변경
        // List<Plan> PlanLS = new ArrayList<>();
        PriorityQueue<Plan> PlanLS = new PriorityQueue<>();
        
        //plans 길이만큼 루프        
        for(int plansIDX = 0 ; plansIDX < plans.length ; plansIDX++)
        {
            String name  = plans[plansIDX][0];
            int start    = hourToMiniute(plans[plansIDX][1]);
            int playtime = Integer.parseInt(plans[plansIDX][2]);
            
            //plan 구조체 생성
            Plan plan = new Plan(name, start, playtime);

            //PlanLs 생성
            PlanLS.add(plan);
        }

        //현재 과제 정보 선언
        String name   = "";
        int startTime = 0;
        int playTime  = 0;

        //과제진행
        while(PlanLS.isEmpty() == false || stopStack.isEmpty() == false)
        {                
            //현재 과제 정보 추출
            name   = PlanLS.peek().name;
            startTime = PlanLS.peek().start;
            playTime  = PlanLS.peek().playtime;
            PlanLS.poll();

            //현재 시간
            int nowTime = startTime;

            //신규과제 있을경우
            if(PlanLS.isEmpty() == false)
            {
                Plan nextPlan = PlanLS.peek();

                //현재과제를 끝내고도 다음 과제까지 남아있는경우
                if(nowTime + playTime <= nextPlan.start)
                {
                    answer.add(name);       //다음과제 전에 지금과제 끝냈음으로 결과에 담아주기
                    nowTime += playTime;    //현재시간 갱신(작업한시간만큼 더해줌)

                    //저장해둔 과제가 있는경우, 남은시간만큼 다시 과제진행
                    while(stopStack.isEmpty() == false)                    
                    {
                        Plan remainPlan = stopStack.pop();      //하던과제 다시 꺼내서 시작
                        
                        // 다음과제 시작전까지 원래하던 과제를 다 끝낼수 있는지 확인
                        if(nowTime + remainPlan.playtime <= nextPlan.start)
                        {
                            nowTime += remainPlan.playtime;     //현재 시간 수정
                            answer.add(remainPlan.name);        //끝낸과제 결과 등록
                            continue;
                        }
                        //다음과제 시작전까지 원래하던과제 다 못끝내는 경우
                        else
                        {
                            //추가작업한 시간만 계산해서 다시 스택에 넣어준다. 확인필요
                            int newRemainTime = remainPlan.playtime - (nextPlan.start - nowTime);
                            stopStack.push(new Plan(remainPlan.name, remainPlan.start, newRemainTime));     // 시작시간을 최신화 시켜줘야하는지? 확인필요
                            break;
                        }
                    }
                }
                //다음과제 시작할시간이 되서, 중간에 하던거 저장해야할 경우
                else
                {
                    int useTime = nextPlan.start - nowTime; //작업한 시간
                    stopStack.push(new Plan(name, startTime, playTime-useTime));       //시작시간은??
                }
            }
            //신규과제가 없고, Stack에만 남아있는경우
            else
            {   
                //저장해둔 과제가 잇는경우
                if(stopStack.isEmpty() == false)
                {
                    answer.add(name);   //현재 꺼낸과제 완료

                    //스택에있는거 차례대로 작업
                    while(stopStack.isEmpty() == false)
                    {
                        Plan remainPlan = stopStack.pop();
                        answer.add(remainPlan.name);
                    }
                }
                //스택에도 없는경우 체크
                else
                {
                    answer.add(name);   //현재 꺼낸과제 완료
                    break;
                }
            }           
        }

        String[] answerArr = new String[plans.length];
        //리스트 to 배열로 변환
        for(int i = 0 ; i< answerArr.length ; i++)
        {
            answerArr[i] = answer.get(i);
        }
        return answerArr;
        
    }

    /**
     * HH:MM 타입을 정수형 인트로 변경해주는 함수
     * @param arr
     * @returnh int iTime
     */
    public int hourToMiniute(String arr){
        int iTime = 0;

        int ihour = Integer.parseInt(arr.replace(":", "").substring(0, 2));
        int iminute = Integer.parseInt(arr.replace(":", "").substring(2, 4));        
        System.out.println("hour : " + ihour);
        System.out.println("minute : " + iminute);

        iTime = (ihour * 60) + iminute;
        System.out.println("iTime : " + iTime);
        return iTime;
    }
}
