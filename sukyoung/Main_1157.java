import java.util.*;


public class Main_1157  {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        String a=sc.next().toUpperCase();
        int []Alphabet=new int[26];             //알파벳 26개 
        int q=0;

        for(int i=0;i<a.length();i++){
            int p=a.charAt(i)-'A';            // 그 알파벳에 맞는 배열에 계속 추가해 주기
            Alphabet[p]++;
        }
        
        int max=0;
        char answer=' ';

        for(int j=0;j<Alphabet.length;j++){
            if(max<Alphabet[j]){
                max=Alphabet[j];
                answer=(char)(j+'A');           //제일 큰 숫자가 나오면 max에 대입
            }
            else if(max == Alphabet[j]){
                answer='?';                     //만약 max와 같은 것이 나오면 ?로 나오게 하기
            }
        }
        System.out.print(answer);
    }

}
