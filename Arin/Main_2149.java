import java.util.Arrays;
import java.util.Scanner;

public class Main_2149{
    static char[] key;
    static char[] code;

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String keystring = sc.next();
        String codestring = sc.next();

        key = keystring.toCharArray();
        code = codestring.toCharArray();

        arr = new char[key.length][code.length/key.length];

        int code_content_no = 0;

        //배열 세팅
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < code.length/key.length; j++) {
                arr[j][i] = code[code_content_no];
                code_content_no++;
            }            
        }
        
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.println("["+i+"]["+j+"]: "+arr[i][j]);
        //     }
        // }
        
    }

}