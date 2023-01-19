/**
 *  *  <알고리즘 스터디 26회차 2023.01.18>
 *  LV2_카펫 : https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * 
 * 문제 설명
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 * 
 * 입출력 예
 * brown	yellow	return
 * 10	    2	    [4, 3]
 * 8	    1	    [3, 3]
 * 24	    24	    [8, 6]
 * 
 * 
 * 
 * 
 */

package LV2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;   //타일의 총갯수(넓이)
        int width = 0;              //가로
        int height = 0;             //세로

        //몫을 늘려가면서
        for(int i = 1 ; i<sum-1 ; i++){
            //정수로 나뉠때! 가로, 세로 길이구하기
            if(sum % i == 0){       
                width = sum / i;
                height = i;
            }

            //입력된 노란색 크기랑 같으면 정답임
            if((width - 2) * (height - 2) == yellow){
                answer[0] = width;
                answer[1] = height;
                return answer;                
            }
        }


        return answer;
    }
}