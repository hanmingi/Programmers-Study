package LV2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */

public class MineCraft {
    public static String sDiamond = "diamond";
    public static String sIron = "iron";
    public static String sStone = "stone";



    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int dia_pick = picks[0];    //다곡
        int iron_pick = picks[1];   //철곡
        int stone_pick = picks[2];  //돌곡
        int pickCount = dia_pick + iron_pick +stone_pick;

        //곡괭이를 다쓰는경우 or 끝까지 다캐는경우 둘중 작은걸로 
        int maxSize = Math.min((pickCount * 5),minerals.length);

        ArrayList<Integer> splitMinerals = new ArrayList<>();
        //[][0] : 다곡
        //[][1] : 철곡
        //[][2] : 돌곡

        //5배수로 루프
        for(int i = 0 ; i<maxSize ; i= i+5){
            int tired = 0;

            //5칸씩 짤라서 피로도로 계산
            for(int j = 0 ; j< 5; j++){

                if(maxSize <= i+j){
                    break;
                }
                
                //돌곡으로 캔다 가정했을때, 가장 피로도가 많이드는 위치를 찾아서,
                //역순으로 정렬, 그순서대로 내가 쓸수잇는 다이야-철-돌곡 순으로 사용해야함
                if(minerals[i+j].equals(sDiamond)){       
                    //돌곡사용으로 고정해서 계산(최댓값)
                    //nowPick : [0:다곡],[1:철곡].[2:돌곡]
                    tired += calTired(sDiamond,2);      
                }
                else if(minerals[i+j].equals(sIron)){       
                    //돌곡사용으로 고정해서 계산(최댓값)
                    tired += calTired(sIron,2);
                }
                else/*(minerals[i+j].equals(sStone))*/{       
                    //돌곡사용으로 고정해서 계산(최댓값)
                    tired += calTired(sStone,2);
                }
            }
            splitMinerals.add(tired);

        }


        
        while(Collections.max(splitMinerals) != 0){
            
            //기존 배열을 5개씩 피로도를 나뉘어 구한 ArrayList임,
            //ArrayList의 순서를 훼손하지 않으면서 현재 MAX값의 index를 (MAX피로도 구간을 찾아야함)            
            int max = Collections.max(splitMinerals);
            //ArrayList의 가장 큰 값을 max로 받아온뒤, indexOf로 ArrayList의 몇번째 있는지 알수있음
            // 그수에 5배를 곱해주면, 기존배열의 index 위치를 구할수있음
            int index = splitMinerals.indexOf(max) * 5;
            System.out.println("indexof : "  + splitMinerals.indexOf(31));
            System.out.println("index : " + index);

            //다곡 사용
            if(picks[0] > 0 ){
                picks[0]--;
                //선택한 곡괭이 5번 사용
                for(int i = index ; i< index+5 ; i++){
                    //out of Range 탈출
                    if(i >= minerals.length){break;}

                    answer += calTired(minerals[i],0);
                }
            }
            //다곡없으면 철곡사용
            else if(picks[1] > 0 ){
                picks[1]--;
                //선택한 곡괭이 5번 사용
                for(int i = index ; i< index+5 ; i++){
                    //out of Range 탈출
                    if(i >= minerals.length){break;}

                    answer += calTired(minerals[i],1);
                }
            }
            //다곡,철곡 둘다없으면 돌곡사용            
            else if(picks[2] > 0 ){
                picks[2]--;
                //선택한 곡괭이 5번 사용
                for(int i = index ; i< index+5 ; i++){
                    //out of Range 탈출
                    if(i >= minerals.length){break;}

                    answer += calTired(minerals[i],2);
                }
            }
            //싹다없는경우 탈출
            else{
                break;
            }

            //이미 캐버린 5칸 index 초기화
            splitMinerals.set(splitMinerals.indexOf(max), 0);
        }
        
        return answer;
    }


    //피로도 계산메소드
    public int calTired(String sMineral,  int nowPick){        
        //다야
        if(nowPick == 0 ){
            if(sMineral.equals(sDiamond)){
                return 1;
            }
            else if(sMineral.equals(sIron)){
                return 1;
            }
            else if(sMineral.equals(sStone)){
                return 1;
            }
            else{
                System.out.println("error");
            }
        }
        //철
        else if(nowPick == 1 ){
            if(sMineral.equals(sDiamond)){
                return 5;
            }
            else if(sMineral.equals(sIron)){
                return 1;
            }
            else if(sMineral.equals(sStone)){
                return 1;
            }
            else{
                System.out.println("error");
            }

        }
        //돌
        else if(nowPick == 2 ){
            if(sMineral.equals(sDiamond)){
                return 25;
            }
            else if(sMineral.equals(sIron)){
                return 5;
            }
            else if(sMineral.equals(sStone)){
                return 1;
            }
            else{
                System.out.println("error");
            }
            
        }
        else{
            System.out.println("error");            
        }
        return 0;        
    }



    /**실패 */
    /**
     * 최초 접근방식, 
     * 처음부터 순차적으로 5개씩 캔다 가정할때, 5개중에서 가장 많은 광물로 만든 곡괭이를 사용하면 된다고 생각하고 접근함
     * 예를들어, 다이아몬드가 가장많으면 다곡으로 캐는게 합리적이고 철이 가장많으면, 철곡으로 캐는것이, 
     * 마찬가지로 돌이 가장 많으면 돌곡으로 캐는것이 합리적이다 판단함
     * 따라서 5칸식 순회하면서 각각의 광물들을 카운팅, picksArr에 순서대로 어떤 곡괭이를 사용하면 좋을지 리스트화 시킴
     * 
     * BUT! 가장 앞단인 minerals[0]부터 캐기 시작하면, 피로도의 최소값을 구하기 어려워짐,
     * 왜냐하면 
     * 1) 다이아몬드, 철 등이 뒤쪽에 몰려나올수도 있음, 
     * 2) 가장 합리적인 곡괭이를 내가 소지하고 있지 않을떄, 어떻게 다른 곡괭이로 대체할것인지?     
     *      
     */
    public int solution2(int[] picks, String[] minerals) {
        int answer = 0; //피로도
        int index = 0;
        ArrayList<Integer> picksArr = new ArrayList<>();

        while(index < minerals.length){
            int diaCount = 0;
            int ironCount = 0;
            int stoneCount = 0;
            int last = index+5;            
            for(int i = index ; i<last ; i++){
                
                //out of range check
                if(i >= minerals.length){
                    break;
                }
                if(minerals[index].equals(sDiamond)){
                    diaCount++;
                }
                else if(minerals[index].equals(sIron)){
                    ironCount++;
                }
                else if(minerals[index].equals(sStone)){
                    stoneCount++;
                }
                else{
                    System.out.println("error!");
                }
                index++;
            }

            //다곡
            if(diaCount >= ironCount && diaCount >= stoneCount){
                //다곡선택
                picksArr.add(0);
            }
            //철곡
            else if(ironCount >= diaCount && ironCount >= stoneCount){
                //철곡선택
                picksArr.add(1);
            }
            //돌곡
            else if(stoneCount >= ironCount && stoneCount >= diaCount){
                //돌곡선택
                picksArr.add(2);
            }
            else{
                System.out.println("errorCase");
            }
        }
        System.out.println("총 필요한 곡괭이 갯수 : " + picksArr.size());
        
        int nowPick = 999;
        //피로도계산
        for(int j = 0 ; j< minerals.length ; j++){            
            if(j % 5 == 0){
                nowPick = picksArr.get(0);
                picksArr.remove(0);
                picks[nowPick]--;
                
                //새 곡괭이를 선택하는데 그 최선의 곡괭이가 없는경우는 남아있는것중에서 선택해야함
                //ㄴ> HOW? 경우의수가 많아서 안됨
                        //ㄴ> 무조건 다곡을 먼저쓴다? -> 뒤쪽에서 다야 왕창나오면 False,                         
                //--> 애초에 곡괭이별로 피로도를 각각 계산해서 따로 처리해야할듯
                //   -> 아싸리 돌곡기준으로 계산해서 나올수있는 MAX피로도를 구하고, 그 MAX값
                //        index순서대로 내가가지고있는 최고 곡괭이로 캐면안되나?
                if(picks[nowPick] < 0 ){
                    System.out.println("test");                    
                    // if(picks[0] <0){}
                    // else if(picks)
                }
            }

            //곡괭이 살아있는지 체크
            nowPick = chkPick(nowPick,picks);            

            //다곡
            if(nowPick == 0 ){
                // //현재 다곡 없을경우 철곡으로 다운
                // if(picks[0] < 0){ 
                //     nowPick = 1;                     
                //     continue;
                // }
                int tired = calTired(minerals[j],0);
                System.out.println("mineral : "+ minerals[j]+ ", tired : " + tired + ", index : " + j );
                answer += tired;

                
            }
            //철곡
            if(nowPick == 1){
                //현재 철곡 없을경우 돌곡으로 다운
                // if(picks[1] < 0){ nowPick = 2;}
                int tired = calTired(minerals[j],1);
                System.out.println("mineral : "+ minerals[j]+ ", tired : " + tired + ", index : " + j );
                answer += tired;
            }
            //돌곡
            if(nowPick == 2){
                //현재 돌곡 없을경우 끝난거임
                if(picks[2] < 0){ 
                    nowPick = 999;
                     break;
                }  
                int tired = calTired(minerals[j],2);
                System.out.println("mineral : "+ minerals[j]+ ", tired : " + tired + ", index : " + j );
                answer += tired;
            } 
            
            if(nowPick == 999){
                break;
            }
        }
        return answer;
    }

    public int chkPick(int nowpick, int[] picks){
        //-2가 나오면 에러처리함
        if(picks[0] < -1 ||picks[1] < -1 || picks[2] < -1 ){
            nowpick = 999;
            return nowpick;
        }
        if(picks[nowpick] < 0){
            nowpick++;      //곡괭이 다운시키고
            picks[nowpick]--;         //곡괭이 남은개수 차감
        }    
        return nowpick;    
    }

    public int calTired2(String sMineral,  int nowPick){        
        //다야
        if(nowPick == 0 ){
            if(sMineral.equals(sDiamond)){
                return 1;
            }
            else if(sMineral.equals(sIron)){
                return 1;
            }
            else if(sMineral.equals(sStone)){
                return 1;
            }
            else{
                System.out.println("error");
            }
        }
        //철
        else if(nowPick == 1 ){
            if(sMineral.equals(sDiamond)){
                return 5;
            }
            else if(sMineral.equals(sIron)){
                return 1;
            }
            else if(sMineral.equals(sStone)){
                return 1;
            }
            else{
                System.out.println("error");
            }

        }
        //돌
        else if(nowPick == 2 ){
            if(sMineral.equals(sDiamond)){
                return 25;
            }
            else if(sMineral.equals(sIron)){
                return 5;
            }
            else if(sMineral.equals(sStone)){
                return 1;
            }
            else{
                System.out.println("error");
            }
            
        }
        else{
            System.out.println("error");            
        }
        return 0;        
    }
}
