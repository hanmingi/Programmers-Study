package LV3;
public class BaseStationins {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int nowLeftPos = 0;     //현재 탐색하는 기지국 좌측값
        int nowRighttPos = 0;   // 현재 탐색하는 기지국 우측값
        int stPos = 0;          // 현재 비어있는 구간 좌측값
        int endPos = 0;         // 현재 비어있는 구간 우측값 
        

        for(int i = 0 ; i< stations.length ; i++){            
            //첫번째 탐색떄 오류잡기위해서 위쪽에서 처리
            stPos = nowRighttPos;

            nowLeftPos = stations[i] - w;
            nowRighttPos = stations[i] + w;           

            //경계값 예외처리
            if(nowLeftPos < 0 ){
                nowLeftPos = 0;
            }
            if(nowRighttPos > n){
                nowRighttPos = n;
            }
            
            endPos = nowLeftPos-1;  //비어있는 구간의 우측값은 현재기지국의 좌측값 -1임

            //2w+1 == 하나의 기지국이 커버하는 범위
            //몫이 구간범위에 필요한 최소 갯수가됨
            answer += (int) Math.ceil((double)((endPos - stPos) / ((double)2*w +1)));
        }

        //nowRightPos 가 N에 도달해야 전범위가 커버됨, for문 탈출시 끝까지 돌았는지 체크
        if(nowRighttPos == n){
            return answer;
        }
        //현재 설치된 마지막 기지국의 범위가 끝까지 커버하지 못하는경우임
        //마지막기지국의 우측부터 끝까지 몇개필요한지 계산해서 추가
        else{
            answer += (int) Math.ceil((double)((n - nowRighttPos) / ((double)2*w +1)));
            return answer;
        }
    }    
}
