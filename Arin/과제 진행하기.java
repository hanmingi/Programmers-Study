import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        HashMap<Integer, String> hmStartSubj = new HashMap<>(); // 과제시작시각과 과제명
        HashMap<String, Integer> hmSubjDur = new HashMap<>(); // 과제명과 과제소요시간
        PriorityQueue<Integer> pqStart = new PriorityQueue<>(); // 과제시작시각 빠른 순으로 정렬하는 우선순위 큐(시작시각 순으로 과제 수행하므로)
        for (String[] pl : plans) {
            int start = Integer.parseInt(pl[1].substring(0, 2)) * 60 + Integer.parseInt(pl[1].substring(3, 5));
            hmStartSubj.put(start, pl[0]);
            pqStart.offer(start);
            hmSubjDur.put(pl[0], Integer.parseInt(pl[2]));
        }
        
        int cur = pqStart.peek(); // 현재 시각(시작시각 우선순위큐의 첫번째 값 담아서 시작한다)
        Stack<String> stWait = new Stack<>(); // 잠시 멈춰둔 과제명 담을 대기열 스택
        String[] answer = new String[plans.length];
        int idx = 0;
        
        // 1. 시작시각 큐 빌 때까지 반복한다
        //while(!pqStart.isEmpty() && pqStart.peek()!=null){ // *peek와 isEmpty 체크의 순서는 상관없다
                                                             // *둘 중 하나만 체크해도 된다
        while(pqStart.peek() != null){
            String subj = hmStartSubj.get(pqStart.peek()); // 현 차례에 수행할 과목명
            // 1-1. 현시각과 수행할 과제시작시각이 같을 때
            if(cur == pqStart.peek()) {
                int dur = hmSubjDur.get(hmStartSubj.get(pqStart.poll())); // 과제시작시각 꺼내고, 소요시간 가져온다
                                                                          // poll했으면 다음 peek 전에 비어있는지 확인해야한다
                                                                          // otherwise, nullPointerException 뜬다
                if(!pqStart.isEmpty()){ // poll하고나서 큐가 비었는지 확인한다
                    if(cur + dur <= pqStart.peek()){ // 현시각+과제소요시간이 다음 과제수행시각이나 그전에 끝날 때
                        answer[idx++] = subj;
                        cur += dur;
                    } else { // 현시각+과제소요시간이 다음 과제수행시각을 넘어갈 때
                        hmSubjDur.replace(subj, (dur-(pqStart.peek()-cur)));
                        stWait.push(subj); // 대기열에 현 과목명 넣는다
                        cur = pqStart.peek();
                    }
                }else{
                    answer[idx++] = subj;
                    break;
                }
            // 1-2. 현재시각과 수행할 과제시작시각이 다를 때 (= 다음 과제 시작 전 시간이 남음)
            }else {
                while(cur != pqStart.peek()){ // 현시각이 다음 과제시작시각과 같아질 때까지
                    if(stWait.isEmpty()) {    // 과제 대기열이 비어있을 때   *peek로 체크시 런타임에러
                        cur = pqStart.peek(); // 바로 다음 과목 수행하도록, 현시각을 다음 과제시각으로 바꾼다
                    }else{ // 과제 대기열에 과제가 있을 때
                        int dur = hmSubjDur.get(stWait.peek()); // 대기열의 첫번째과제 소요시간
                        if(dur + cur == pqStart.peek()) {       // (대기열의 첫번째과제 소요시간 + 현시각)이 다음 과제시작시각과 같을 때
                            hmSubjDur.replace(stWait.peek(), 0); // 대기열 과제 끝냈으므로 남은 소요시간 0으로 바꾼다
                            answer[idx++] = stWait.pop();              // 대기열에서 해당과목명 뺀다
                            cur = pqStart.peek();
                        }else if(dur + cur > pqStart.peek()){ // (대기열의 첫번째과제 소요시간 + 현시각)이 다음 과제시작시각을 넘어갈 때
                            hmSubjDur.replace(stWait.peek(),(hmSubjDur.get(stWait.peek())-(pqStart.peek()-cur)));
                            cur = pqStart.peek();
                        }else if(dur + cur < pqStart.peek()){ // (대기열의 첫번째과제 소요시간 + 현시각)이 다음 과제시작시각보다 적을 때
                            cur += dur;                       // 현시각은 과제소요시간 더해준다
                            hmSubjDur.replace(stWait.peek(),0); // 대기열 과제 끝냈으므로 남은 소요시간 0으로 바꾼다
                            answer[idx++] = stWait.pop(); // *pop한 후에 다시 반복문 돌며 peek가 있는 경우 stackEmptyException 나므로
                                                          // *반드시 스택 비었는지 확인 후 peek해야 한다
                        }
                    }
                }
            }
        }

        // 2. 시작시각 큐는 비었지만 대기열에 과목이 남아있는 경우
        //if(!stWait.isEmpty() && stWait.peek() != null){ // *while문만 있어도 된다. || 아니고 &&(stackemptyexception)
            //while(!stWait.isEmpty() && stWait.peek() != null) {
            while(!stWait.isEmpty()) { // *큐와 다르게 스택은 peek로 체크시 stackemptyexception,런타임에러 뜬다
                answer[idx++] = stWait.pop();
            }
        //}
        return answer;
    }
}