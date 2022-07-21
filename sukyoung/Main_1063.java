import java.util.*;

public class Main_1063{

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        
        String K=sc.next();
        String S=sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i = 0; i < n; i++){
           arr[i] = sc.next();
        }
        
        int kingPosY = K.charAt(1)-48;
        int kingPosX = K.charAt(0) - 64;
        int stonePosY = S.charAt(1)-48;
        int stonePosX = S.charAt(0) - 64;

        
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            switch (str) {
            case "R":
                if (kingPosX < 8) {
                    kingPosX++;
                    if (kingPosY == stonePosY && kingPosX == stonePosX) {
                        if (stonePosX < 8) {
                            stonePosX++;
                        }else {
                            kingPosX--;
                        }
                    }
                }
                break;
 
            case "L":
                if (kingPosX > 1) {
                    kingPosX--;
                    if (kingPosY == stonePosY && kingPosX == stonePosX) {
                        if (stonePosX > 1) {
                            stonePosX--;
                        }else {
                            kingPosX++;
                        }
                    }
 
                }
                break;
 
            case "B":
                if (kingPosY > 1) {
                    kingPosY--;
                    if (kingPosY == stonePosY && kingPosX == stonePosX) {
                        if (stonePosY > 1) {
 
                            stonePosY--;
                        }else {
                            kingPosY++;
                        }
                    }
                }
                break;
 
            case "T":
                if (kingPosY < 8) {
                    kingPosY++;
                    {
                        if (kingPosY == stonePosY && kingPosX == stonePosX) {
                            if (stonePosY < 8) {
                                stonePosY++;
                            }else {
                                kingPosY--;
                            }
                            
                        }
                    }
                }
                break;
 
            case "RT":
                if (kingPosY < 8  && kingPosX < 8 ) {
                    kingPosX++;
                    kingPosY++;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosY <8 && stonePosX <8) {
                            
                            stonePosX++;
                            stonePosY++;
                        }else {
                            kingPosX--;
                            kingPosY--;
                        }
                    }
                }
 
                break;
 
            case "LT":
                if (kingPosY < 8  && kingPosX > 1 ) {
                    kingPosY++;
                    kingPosX--;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosY < 8 && stonePosX >1) {
                            
                            stonePosX--;
                            stonePosY++;
                        }else {
                            kingPosX++;
                            kingPosY--;
                        }
                    }
                }
 
                break;
 
            case "RB":
                if (kingPosY > 1 && kingPosX < 8) {
                    kingPosX++;
                    kingPosY--;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosY >1 && stonePosX <8) {
                            stonePosX++;
                            stonePosY--;
                            
                        }else {
                            kingPosX--;
                            kingPosY++;
                        }
                    }
                }
                
                break;
 
            case "LB":
                if (kingPosX > 1  && kingPosY > 1 ) {
                    kingPosY--;
                    kingPosX--;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosX>1 && stonePosY >1) {
                            stonePosY--;
                            stonePosX--;
                            
                        }else {
                            kingPosY++;
                            kingPosX++;
                        }
                    }
                }
 
                break;
 
            default:
                break;
            }
        }
        String kingStr = "";
        kingStr += (char) (kingPosX + 64);
        System.out.println(kingStr + kingPosY);
        String stoneStr = "";
        stoneStr += (char) (stonePosX + 64);
        System.out.println(stoneStr + stonePosY);
    }
}
