import java.util.*;

public class Main_2149{ //암호해독
    static char[] key;
    static char[] code;

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //키와 암호 문구 입력받음
        String keystring = sc.next();
        String codestring = sc.next();

        //키와 암호 문구를 char 배열로 바꿈
        key = keystring.toCharArray();
        code = codestring.toCharArray();

        arr = new char[code.length/key.length][key.length];

        int code_content_no = 0;

        //배열 세팅
        for (int i = 0; i < code.length/key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                arr[j][i] = code[code_content_no];
                code_content_no++;
            }            
        }

        //key배열 정렬
        char[] sortedKey = key.clone();
        Arrays.sort(sortedKey);
        boolean[] visited = new boolean[key.length];
        int[] keyCharacterIndex = new int[key.length];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < key.length; i++) {
            keyCharacterIndex[i] = 0;
        }

        //key의 각 문자에 순서대로 인덱스를 달고, 정렬된 sortedKey의 순서대로 keyCharacterIndex배열에 숫자를 넣어준다
        //ex) key = {K,E,Y} >> sortedKey = {E,K,Y} >> keyCharacterIndex = {1,0,2}
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(sortedKey[j] == key[i] && !visited[j]){
                    visited[j] = true;
                    keyCharacterIndex[j] = i;
                    break;
                }                
            }
        }

        char[][] originalText = new char[code.length/key.length][key.length];
        for (int i = 0; i < code.length/key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                originalText[i][keyCharacterIndex[j]] = arr[i][j];
            }         
        }

        for(int i = 0; i < code.length/key.length; i++){
            for(int j = 0; j < key.length; j++){
                System.out.print(originalText[i][j]);
            }
        }
        
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.println("["+i+"]["+j+"]: "+arr[i][j]);
        //     }
        // }
        
    }

}