import java.util.*;

public class Main_2149{
    static char[] key;
    static char[] s;

    static int C;
    static int R;

    static char[][] arr;
    static int[] dkey;
    static char[][] plain_text;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String key_t = sc.next();
        String s_t = sc.next();

        key = key_t.toCharArray();
        s = s_t.toCharArray();

        C = key.length;
        R = s.length / C;

        arr = new char[R][C];

        set_arr();

        get_key();

        solved();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(plain_text[i][j]);
            }
        }
    }

    static void set_arr(){
        int idx = 0;
        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                arr[j][i] = s[idx];
                idx++; 
            }
        }
    }

    static void get_key(){
        char[] sort_arr = key.clone();
        Arrays.sort(sort_arr);
        boolean[] visited = new boolean[key.length];
        dkey = new int[key.length];

        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }

        for(int i = 0; i < key.length; i++){
            dkey[i] = 0;
        }

        for(int i = 0; i < C; i ++){
            for(int j = 0; j < C; j++){
                if(sort_arr[j] == key[i] && !visited[j]){
                    visited[j] = true;
                    dkey[j] = i;
                    break;
                }
            }
        }
    }

    static void solved(){
        plain_text = new char[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                plain_text[i][dkey[j]] = arr[i][j];
            }
        }
    }
}