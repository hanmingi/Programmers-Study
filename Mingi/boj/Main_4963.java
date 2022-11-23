//package develope;

import java.util.Scanner;

public class Main_4963 {
    
    static int[][] land;
    static boolean[][] visit;
    static int W;
    static int H;

    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int count;

            while(true){
                W = sc.nextInt();
                H = sc.nextInt();
                
                count = 0;

                if(W == 0 && H == 0) break;

                land = new int[H][W];
                visit = new boolean[H][W];
   
                for(int i = 0; i < H; i++){
                    for(int j = 0; j < W; j++){
                        land[i][j] = sc.nextInt();       
                    }
                }

                for(int i = 0; i < H; i++){
                    for(int j = 0; j < W; j++){
                        if(land[i][j] == 1 && !visit[i][j]){
                            dfs(i, j);
                            count++;       
                        }
                    }
                }

                System.out.println(count);
            }
        }
    }
    
    static void dfs(int h, int w){
        int[] dx = {0, -1, 0, 1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

        visit[h][w] = true;

        for(int i = 0; i < 8; i++){
            int cx = w + dx[i];
            int cy = h + dy[i];

            if(cx >= 0 && cy >= 0 && cx < W && cy < H){
                if(!visit[cy][cx] && land[cy][cx] == 1){
                    dfs(cy, cx);
                }
            }
        }
    }
}
