import java.util.Scanner;

public class Main_1254 { // 팰린드롬 만들기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //String str = "qwerty";
        //String str = "oooio";
        int answer = str.length(); // 출력할 정답에 주어진 문자열의 길이 넣어놓음.
                                   // 그대로이거나 증가할 예정.
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i))) // 앞글자를 하나씩 제거하며
                                                // 나머지 문자가 팰린드롬인지 검사
                break; // 팰린드롬이면 for문 나가서 answer 출력
            answer++; // 팰린드롬이 아니라면 적어도 문자열 뒤에 같은 문자를
                      // 하나 붙여야 팰린드롬이 되므로 answer 증가시킴
        }
        System.out.println(answer);

    }

    // 주어진 문자열이 팰린드롬인지 판단하는 함수
    private static boolean isPalindrome(String str) {
        int first = 0; // 문자열 첫 글자
        int last = str.length() - 1; // 문자열 마지막 글자
        while (first <= last) { // 문자열의 처음과 마지막에서 시작해서 중간 글자까지 반복
            if (str.charAt(first) != str.charAt(last)) // 첫 글자와 마지막 글자가 다르면
                return false;                          // 팰린드롬일 수 없으므로 false 반환
            first++;
            last--;
        }
        return true;
    }
}