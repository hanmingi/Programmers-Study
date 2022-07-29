import java.util.Scanner;

public class Main_1157 { //단어 공부
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase(); //영어단어 입력 받아서 대문자로 변환

        int[] alphabet = new int[26]; //알파벳 26개만큼의 배열 만듦

        for (int i = 0; i < word.length(); i++) {
            int n = word.charAt(i) - 'A'; //입력받은 영단어 각 알파벳의 아스키코드-65 n에 담기
            alphabet[n]++;
        }

        // for (int i = 0; i < count.length; i++) {
        // System.out.println(i+": "+count[i]);
        // }

        int max = 0;
        char result = ' ';

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                result = (char) (i + 'A'); //최대값 가진 알파벳배열의 인덱스에 65 더하여 char형으로 변환(알파벳으로 변환)
            } else if (alphabet[i] == max) { //최대값가진 알파벳배열의 인덱스가 두 개 이상일 때
                result = '?';
            }
        }
        System.out.println(result);

    }
}