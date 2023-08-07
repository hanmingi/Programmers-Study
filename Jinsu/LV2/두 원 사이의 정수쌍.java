package LV2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */

 /**
  * 두 원사이의 정수좌표 갯수를 구한다.
  * 겹치는 부분도 고려해야함
  * 하나의 사분면만 구해서 *4하면 됨
  * ㄴ> 피타고라스 활용   
  */

public class pairTwoCircles {
    public long solution(int r1, int r2) {
        double answer = 0;
        
        double r1pow = Math.pow(r1,    2);
        double r2pow = Math.pow(r2,    2);

        int outerCircle = 0;
        int innercircle = 0;

        for(int i = 1 ; i <r2 ; i++)
        {
            //큰원의 최대치 내림
            outerCircle = (int) Math.floor(Math.sqrt(r2pow - Math.pow(i, 2)));

            if(i < r1)
            {
                //작은원의 최소치 올림
                innercircle = (int) Math.ceil(Math.sqrt(r1pow - Math.pow(i, 2)));   
            }
            else
            {
                innercircle = 1;
            }
            answer += (outerCircle - innercircle + 1);
        }
        
        //내부점 + 축위의 점들 합산
        answer = (answer + r2 - r1 + 1) * 4;
        
        return (long) answer;
    }    
}
