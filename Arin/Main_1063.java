import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1063{ //킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String kingPos = st.nextToken();
        String stonePos = st.nextToken();

        int n = Integer.parseInt(st.nextToken());

        String[] move = new String[n];
        for (int i = 0; i < move.length; i++) {
            move[i] = br.readLine();
        }

        int kx = kingPos.charAt(0) - 'A' + 1; // A>1 B>2 C>3 D>4
        int ky = kingPos.charAt(1) - '0';
        int sx = stonePos.charAt(0) - 'A' + 1;
        int sy = stonePos.charAt(1) - '0';

        // System.out.println("kx: "+kx);
        // System.out.println("ky: "+ky);
        // System.out.println("sx: "+sx);
        // System.out.println("sy: "+sy);
        
        for (int i = 0; i < move.length; i++) {
            String str = move[i];
            switch (str) {
                //x와 y는 1~8에서만 움직일 수 있음
                case "R":
                    if(kx <= 7){ //킹의 가로 위치가 7이하일 때만 움직임
                        kx++;
                        if(kx==sx&&ky==sy){ //킹과 돌이 만나면
                            if(sx <= 7){ //돌의 가로 위치가 7이하일 때만 움직임
                                sx++;
                            }else{
                                kx--; //돌의 가로 위치가 7일 때(=오른쪽으로 더 갈 수 없음) 킹의 위치 원위치시킴
                            }
                        }
                    }
                    break;
                
                case "L":
                    if(kx >= 2){ //킹의 가로 위치가 2이상일 때만 움직임
                       kx--;
                       if(kx==sx&&ky==sy){ 
                           if(sx >= 2){
                               sx--;
                            }else{
                              kx++;
                           }
                       }
                    }
                    break;

                case "B": //아래로
                    if(ky >= 2) { //킹의 세로 위치가 2이상일 때만 움직임
                        ky--;
                        if(kx==sx&&ky==sy){
                            if(sy >= 2){
                                sy--;
                            }else{
                                ky++;
                            }
                        }
                    }
                    break;

                case "T": //위로
                    if(ky <= 7) { //킹의 세로 위치가 7이하일 때만 움직임
                        ky++;
                    }
                    if(kx==sx&&ky==sy){
                        if(sy <= 7){
                            sy++;
                        }else{
                            ky--;
                        }
                    }
                    break;

                case "RT": //오른쪽 위 대각선
                    if(kx <= 7 && ky <= 7) {
                        kx++;
                        ky++;
                    }
                    if(kx==sx&&ky==sy){
                        if(sx <= 7 && sy <= 7){
                            sx++;
                            sy++;
                        }else{
                            kx--;
                            ky--;
                        }
                    }
                    break;

                case "LT": //왼쪽 위 대각선
                    if(kx >= 2 && ky <= 7) {
                        kx--;
                        ky++;
                    }
                    if(kx==sx&&ky==sy){
                        if(sx >= 2 && sy <= 7){
                            sx--;
                            sy++;
                        }else{
                            kx++;
                            ky--;
                        }
                    }
                    break;

                case "RB": //오른쪽 아래 대각선
                    if(kx <= 7 && ky >= 2) {
                        kx++;
                        ky--;
                    }
                    if(kx==sx&&ky==sy){
                        if(sx <= 7 && sy >= 2){
                            sx++;
                            sy--;
                        }else{
                            kx--;
                            ky++;
                        }
                    }
                    break;

                case "LB": //왼쪽 아래 대각선
                    if(kx >= 2 && ky >= 2) {
                        kx--;
                        ky--;
                    }
                    if(kx==sx&&ky==sy){
                        if(sx >= 2 && sy >= 2){
                            sx--;
                            sy--;
                        }else{
                            kx++;
                            ky++;
                            }
                        }
                    break;

                 default:
                     break;
                }
        }

        System.out.print((char)(kx+65-1));
        System.out.print(ky);
        System.out.println();
        System.out.print((char)(sx+65-1));
        System.out.print(sy);
    }

}