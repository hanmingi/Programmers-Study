package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    public static void main(String[] args) {
        Solution_미로 s = new Solution_미로();

        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        System.out.println(s.solution(maps)); //16
    }
}

class Solution_미로 {
    static char[][] map;
    static int[][] visit;
    static int width;
    static int height;

    static int[] dx = {0 ,0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(String[] maps) {
        int answer = 0;
        width = maps[0].length();
        height = maps.length;

        map = new char[height][width];
        visit = new int[height][width];

        for(int i =0 ; i < height; i++){
            Arrays.fill(visit[i], -1);
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        Position start = findPos('S');
        Position lever = findPos('L');
        Position end = findPos('E');

        //시작지점부터 레버까지 경로
        bfs(start, lever);
        int tmp = visit[lever.y][lever.x];

        if(tmp == -1) return -1;
        answer += tmp;

        visit = new int[height][width];
        for(int i = 0; i < height; i++){
            Arrays.fill(visit[i], -1);
        }

        bfs(lever, end);

        tmp = visit[end.y][end.x];
        if(tmp == -1) return -1;
        answer += tmp;

        return answer;
    }

    static void bfs(Position start, Position end){
        Queue<Position> q = new LinkedList<>();
        q.add(start);

        visit[start.y][start.x] = 0;
        if(start.x == end.x && start.y == end.y) return;

        while(!q.isEmpty()){
            Position now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(checkPosition(nx, ny) && visit[ny][nx] == -1){
                    q.add(new Position(ny, nx));
                    visit[ny][nx] = visit[now.y][now.x] + 1;
                }

                if(end.x == nx && end.y == ny) return;
            }

        }
    }

    static boolean checkPosition(int x, int y){
        return x >= 0 && x < width && y >= 0 && y < height && map[y][x] != 'X';
    }

    static Position findPos(char c){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(c == map[i][j]) return new Position(i, j);
            }
        }
        return new Position(-1, -1);
    }

    static class Position{
        int x, y;

        public Position(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

}
