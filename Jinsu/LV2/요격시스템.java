package LV2;

import java.util.PriorityQueue;

public class InterCeptionSys {
      public int solution(int[][] targets) {        
        PriorityQueue<Missile> MissileLs = new PriorityQueue<>();
        
        //targets만큼 루프        
        for(int i = 0 ; i < targets.length; i++)
        {
            Missile missile = new Missile(targets[i][0],targets[i][1]);
            MissileLs.add(missile);
        }
        
        
        //최초좌표 설정
        int lsSize = MissileLs.size();
        int left = MissileLs.peek().startPoint;
        int right = MissileLs.peek().endPoint;
        int answer = 1; //미사일 개수 범위값 1부터 시작
        
        //범위 탐색
        for(int i = 0 ; i < lsSize; i++)
        {
            Missile missile = MissileLs.poll();
            // System.out.println(missile.startPoint + "," + missile.endPoint);
            if(missile.startPoint >= right) //새로운 범위가 기존 범위를 벗어나는경우, 
            {
                answer++;
                right = missile.endPoint; //새로운 범위 등록
            }
            
        } 
        return answer;
    }
    
    public class Missile implements Comparable<Missile>
    {
        int startPoint;
        int endPoint;

        public Missile(int startPoint, int endPoint)
        {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }
        //우선순위큐를 Missile클래스로 사용하기위해 compareTo메소드 오버라이딩
        @Override
        public int compareTo(Missile target)
        {            
            return this.endPoint >= target.endPoint ? 1 : - 1;    //Right기준으로 오름차순 정렬
        }

    }
}
