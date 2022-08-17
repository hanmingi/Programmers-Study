class Solution_BigNumber { // 큰 수 만들기
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int max = 0;
        int start = 0;
        for (int i = 0; i < number.length() - k; i++) { // [number길이 - k] 개의 수를 뽑아야 함. ex) 10-4=6개
            max = 0;
            for (int j = start; j <= k + i; j++) {
                // start : 반복시작할 인덱스
                // k+i : number길이 - 뒤에남겨놓을자리수[number길이-k-(i+1)] - 1(인덱스0부터니까)
                if (max < number.charAt(j) - '0') {
                    // charAt()은 char타입이고 이를 int형으로 변환하면 해당 아스키코드값이 나온다.
                    // ex) char형 '1'을 변환하면 int형 49가 됨.
                    // 따라서 숫자와 비교 하려면 '0'(아스키코드 48)을 빼준다.
                    max = number.charAt(j) - '0';   
                    start = j + 1;                  
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}

public class 큰수만들기 {
    public static void main(String[] args) {
        Solution_BigNumber s = new Solution_BigNumber();
        String number = "4177252841"; // 10자리
        int k = 4;
        System.out.println(s.solution(number, k));
    }
}