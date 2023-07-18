package LV2;

/**
 * 라이언 : 전 우승자 -> 패널티
 * 어피치 : 도전자
 * 1. 어피치가 다쏜뒤 라이언이 쏨
 * 2. 점수판은 0점~10점 , 총 11가지
 * 
 * 각 점수라인(K)에 더 많이 맞춘 선수가 K점을 가저감, a=b일경우 어피치가 가짐
 * 최종점수가 높은쪽이 우승, 같을경우 어피치가 우승
 * 어피치가 다 쏜상황, 라이언이 가장 큰 차이로 이기기 위해서는?
 * 
 * 
 * param : 
 *          화살의 개수 N
 *          어피치가 이미 쏜 10점부터 0점까지 순서대로 담은 배열 info
 * return : 가장 큰점수로 이기기위한 10점~0점순서 정수배열, 못이기면 -1리턴
 * 
 * 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 
 * 가장 낮은 점수를 더 많이 맞힌 경우를 return
 * 
 */

 
public class ArcheryCompetition {

    public static int Number, max, disnt;
    public static int[] apeach, lion, answer;

     public int[] solution(int n, int[] info) {

        answer = new int[] { -1 };
        Number = n;
        lion = new int[11];
        apeach = info;
        max = Integer.MIN_VALUE;
        search(0);

        
        return answer;
    }


     public static void search(int idx) {
        
        //라이언이 쏜갯수와 인덱스(깊이)가 동일할경우, 점수계산
        if (idx == Number) 
        {
            int[] score = new int[2];// 0어피치 / 1 라이언
            for (int i = 0; i < 11; i++) 
            {
                //화살수 같아서 점수 캔슬
                if (apeach[i] == 0 && lion[i] == 0)
                {
                    continue;
                }                   
                //어피치가 이길경우    
                if (apeach[i] >= lion[i])
                {
                    score[0] += 10 - i;
                }                   
                //라이언이 이길경우    
                else
                {
                    score[1] += 10 - i;
                }                    
            }

            //TODO : 최종점수 게산
            if(score[0] >= score[1])        //score[0] : 어피치총점수,score[1] : 라이언총점수
            {
                return;        //라이언이 졌음
            } 
            else 
            {
                disnt = score[1] - score[0] ;      // 라이언이 이기면 점수차 계산
            }

            //점수차가 MAX값인지?
            if(max <= disnt)
            {
                max = disnt;
                answer = lion.clone();
            }
            return;           
        }

        //모든 경우의 수 탐색
        for (int i = 0; i < 11; i++) {
            if(lion[i] > apeach[i]) 
            {
                break;      //라이언이 쏜 화살수 > 어피치가 쏜 화살수 ? -> 탈출! why? 더 많이쏴서 점수 get!, 굳이 끝까지 탐색할 필요가 없음! 한발만 더쏘면됨
            }

            lion[i]++;  //라이언 쐈음!
            search(idx + 1); //깊이 올려서 다시 탐색~ == 모든 경우의수 비교!
            lion[i]--; //-> 깊이탐색 끝났으니 화살수 빼주기!
        }
    }
    
}
