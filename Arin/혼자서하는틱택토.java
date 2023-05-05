class Solution {
    public int solution(String[] board) {        
        // 다음 1,2,3의 경우는 규칙 지킨 게임 상황이 아님(0 return)
        // 1. X가 더 많거나 X와 O가 2 이상 차이나는가?
        int Xs = 0;
        int Os = 0;
        for(int i =0; i < board.length; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j)=='O') Os++;
                else if(board[i].charAt(j)=='X') Xs++;
            }
        }
        if(Xs > Os || Os-Xs > 1) return 0;
        
        // 2. 일직선 같은 표시가 2줄 이상인가? (예외 있긴 함. 밑에서 설명)
        int Ocomplete = 0; // O로 일렬 완성된 줄 수
        int Xcomplete = 0; // X로 일렬 완성된 줄 수
        for(int i = 0; i < board.length; i++){
            // 2-1. 가로 체크
            if(board[i].charAt(0)!='.'&&board[i].charAt(0)==board[i].charAt(1)&&board[i].charAt(1)==board[i].charAt(2)) {
                if(board[i].charAt(0)=='O') Ocomplete++;
                else Xcomplete++;
            }
            // 2-2. 세로 체크
            if(board[0].charAt(i)!='.'&&board[0].charAt(i)==board[1].charAt(i)&&board[1].charAt(i)==board[2].charAt(i)) {
                if(board[0].charAt(i)=='O') Ocomplete++;
                else Xcomplete++;
            }
        }
        // 2-3. 대각선(/슬래시) 체크
        if(board[0].charAt(2)!='.'&&board[0].charAt(2)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(0)) {
                if(board[0].charAt(2)=='O') Ocomplete++;
                else Xcomplete++;
            }
        // 2-4. 대각선(＼역슬래시) 체크
        if(board[0].charAt(0)!='.'&&board[0].charAt(0)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(2)) {
                if(board[0].charAt(0)=='O') Ocomplete++;
                else Xcomplete++;
            }
        
        // if(Ocomplete + Xcomplete > 1) return 0; // 틀림!!(예외) 마지막 O 하나 둠으로써 O 두 줄이 완성되는 경우가 있음
        if(Ocomplete > 0 && Xcomplete > 0) return 0; // 따라서 O완성줄과 X완성줄이 동시에 있는 경우를 체크해 0 리턴
        
        // 3. O한줄완성이면 O가 X보다 1 많아야 함 or X한줄완성이면 O와 X 수가 같아야 함
        if((Ocomplete==1&&Os-Xs!=1) || (Xcomplete==1&&Os!=Xs)) return 0; 
        
        int answer = 1;
        return answer;
    }
}