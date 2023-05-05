import java.util.*;
 
class Solution {
    public int solution(int[][] jobs) { //이문제 핵심은 현재시간에 만족한다면 처리시간이 짧은 것 부터 나와야함 그이유는 그래야 대기시간이 짧다. 
                                        //어차피 처리시간은 무조건 같은데 처리시간이 앞에 것이 먼저나오면 그만큼 대기는 더 길어지기 때문이다.
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //처리시간 순서대로
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //[][]중 앞의것으로 시작시간 순서대로 
        
        int answer = 0;
        int current = 0; //맨처음시간
        int i = 0;
        while(i < jobs.length || !q.isEmpty()) { //맨처음에는 q가 당연히 비어있기 때문에 또는에 empty도 넣어주어야함
            while(i < jobs.length && jobs[i][0] <= current) {   //뒤에 그리고는 현재보다 작아야지 실행이 가능함
                q.add(new int[] {jobs[i][0], jobs[i][1]});
                i++;
            }
          
//             for (int i = 0; i < jobs.length; i++) {
//                 if(current >= jobs[i][0]) {
//                     q.add(new int[] {jobs[i][0], jobs[i][1]});
//                     if(i == jobs.length-1)
//                         current=jobs.length;
//                 }else {
//                     jobs.length=i;
//                     break;
//                 }
//              }
            
            if(q.isEmpty()) { //큐가 비어있다는 것은 while문 못돔 즉 현재시간보다 예시에 있는것들이 다 크다는 뜻
                current = jobs[i][0]; //다음 작업의 시작시간으로 이동한다.
            } else {
                int[] pq = q.poll(); //우선순위큐에다가 처리시간 순서대로 했기때문에 처리시간 짧은 것들 먼저 나온다
                answer += current + pq[1] - pq[0]; //여기서 temp[1]은 처리시간 temp[0]은 요청시간
                current += pq[1];
            }
        }
        return answer / jobs.length;
        
    }
}
