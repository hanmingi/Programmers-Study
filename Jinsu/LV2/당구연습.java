package LV2;

public class BilliardsPractice {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0 ;i<answer.length; i++){
            // answer[i] = 10000;
            answer[i] = 1000000;
        }

        int endX;
        int endY;
        int stX = startX;
        int stY = startY;

        for(int i = 0 ; i< balls.length; i++){
            endX = balls[i][0];
            endY = balls[i][1];
            
            double length = 0.0;
        
            //같은 X축 or Y축 선상에 있으면 진행방향이 겹쳐서 불가능함
            //거리의 제곱을 반환하는 문제임 -> 즉 루트씌울필요 없음

            //1. 위쪽벽에 맞는 경우
            //반례 -> x1=x2 , y1 < y2  
            // 같은 X축인데 나보다 위에있응경우는 불가능
            if(stX == endX && stY < endY){
                // continue;
            }
            else{
                //피타고라스로 구하면 가로변의 길이를 구하기 힘듬
                //목표지점을 팅기는 면으로 반전시켜서 두점사이 직선의 거리를 구하면 됨
                //endY -> {2(n-endY) + endY} = 2n-endY
                //즉 목표좌표는 (endX,2n-endY)
                int calX = endX-stX;                    //x2-x1
                int calY = ((2*n) - endY) - stY;       //y2-y1
                length = Math.pow(calX, 2) + Math.pow(calY, 2);

                if(answer[i] > length){
                    answer[i] = (int) length;
                }
            }
            //2. 아래쪽벽에 맞는 경우
            //반례 1의 반대 x1=x2 , y1>y2
            //endY -> {endY - 2endY} = -endY
            if(stX == endX && stY > endY){
                // continue;
            }
            else{
                int calX = endX-stX;
                int calY = ((-1) * endY) - stY;
                length = Math.pow(calX, 2) + Math.pow(calY, 2);
                
                if(answer[i] > length){
                    answer[i] = (int) length;
                }
            }

            //3. 왼쪽 벽에 맞는 경우
            //반례 x1>x2 , y1 = y2
            // endX - 2endX = -endX
            if(stX > endX && stY == endY){
                // continue;
            }
            else{
                int calX = (-1*endX)-stX;
                int calY = endY - stY;
                length = Math.pow(calX, 2) + Math.pow(calY, 2);
                if(answer[i] > length){
                    answer[i] = (int) length;
                }
            }
            //4. 오른쪽 벽에 맞는 경우
            //반례 3의 반대 : x1<x2 , y1=y2
            // endx -> endX + 2(M-endX) = 2M-endX
            if(stX < endX && stY == endY){
                // continue;                
            }
            else{
                int calX = ((2*m) - endX) - stX;
                int calY = endY - stY;
                length = Math.pow(calX, 2) + Math.pow(calY, 2);
                if(answer[i] > length){
                    answer[i] = (int) length;
                }
            }
        }
        return answer;
    }
    
}
