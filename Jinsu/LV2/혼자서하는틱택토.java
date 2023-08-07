package LV2;

public class SelfTicTactoe {
    public static int MAX_WIDTH = 3;
    public static int MAX_HEIGHT = 3;
    public int solution(String[] board) {
        String[][] arr = new String[MAX_WIDTH][MAX_HEIGHT];        
        int answer = 1;     //1이면 실패, 0이면 성공
        int countO = 0;
        int countX = 0;

        for(int i = 0 ; i<MAX_WIDTH ;i++){
            for(int j = 0; j<MAX_HEIGHT ; j++){
                char slice = board[i].charAt(j);
                if(slice == '.'){
                    arr[i][j] = String.valueOf(slice);                    
                }                    
                else{
                    //개수카운팅
                    arr[i][j] = String.valueOf(slice);
                    if(String.valueOf(slice).equals("O")){
                        countO++;
                    }
                    else{
                        countX++;
                    }
                }
            }       
        }  

        //O가 선공일때, X가 더 작아야함
        if(countX > countO){answer = 0;}

        //O가 선공일때, X와 차이가 2개이상나면 안됨
        if(countO > countX+1){answer = 0;}

        //둘다이기는경우 제외           
        if(isWin("O", arr) && isWin("X", arr)){            
            answer = 0;
            return answer; // 여기서 탈출 안시켜두면 아래쪽 X승리시에 정답처리로 빠짐.
        }
        
        //선공이 승리시, O = X+1
        if(isWin("O", arr)){            
            if(countO == (countX+1)){
                answer = 1;
            }
            else{
                answer = 0;
            }
        }

        //후공 승리시 개수가 같아야함
        if(isWin("X", arr)){
            if(countO == countX){
                answer = 1;
            }
            else{
                answer = 0;
            }
        }

        return answer;
    }

    public boolean isWin(String OX, String[][] arr){                
        for(int i = 0 ; i<3 ; i++){
            //가로행으로 3개 놔서 이기는경우
            if(arr[i][0].equals(OX) && arr[i][1].equals(OX) && arr[i][2].equals(OX)){
                return true;
            }
            //세로행으로 3개 놔서 이기는경우
            if(arr[0][i].equals(OX) && arr[1][i].equals(OX) && arr[2][i].equals(OX)){
                return true;
            }                        
        }
        //대각선 이기는거 두종류
        if(arr[0][0].equals(OX) && arr[1][1].equals(OX) && arr[2][2].equals(OX))
            return true;
        if(arr[0][2].equals(OX) && arr[1][1].equals(OX) && arr[2][0].equals(OX))
            return true;
        return false;
    }
}
