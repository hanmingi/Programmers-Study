package LV2;

/**
 *  LV2_N^2 배열 자르기 : https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 
 * 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
 * n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
 * i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
 * 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
 * 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
 * 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
 * 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항)
 * 1 ≤ n ≤ 107
 * 0 ≤ left ≤ right < n2
 * right - left < 105
 */

public class n2ArraySlice {

    //메모리초과남!!!
    public int[] solution(int n, long left, long right) 
    {
        int[][] OriginalArr = new int[n][n];
        int[] SliceArr = new int[n*n];
        long answerLength = right - left + 1;   

        int[] answer = new int[(int)answerLength];
        
        
        //input
        for(int i = 0 ; i<n ; i++)
        {
            for(int j = 0 ; j<n ; j++)
            {
                if(i > j)
                    OriginalArr[i][j] = i + 1;
                else if(j > i)
                    OriginalArr[i][j] = j + 1;
                else                    
                    OriginalArr[i][j] = j + 1;
            }
        }

        //1차원 배열로 변환
        for (int i = 0; i < OriginalArr.length; i++) {
			for (int j = 0; j < OriginalArr[i].length; j++) {
				SliceArr[OriginalArr[i].length * i + j] = OriginalArr[i][j];
			}
		}
        
        int j = 0;
        //answer 입력
        for(int i = (int)left ; i<(int)right + 1 ; i++)
        {            
            answer[j] = SliceArr[i];
            j++;
        }       
        return answer;
    }

    
    public int[] solution2(int n, long left, long right){
        long answerLength = right - left + 1;  
        int[] answer = new int[(int)answerLength];

        for(int i = 0 ; i< answer.length ; i++){
            //test case 12~20 실패 
            // int row = ((i + (int)left) / n) + 1;
            // int col = ((i + (int)left) % n) + 1;
            int row = (int)((i + left) / n) + 1;
            int col = (int)((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }
        return answer;
    }
}
