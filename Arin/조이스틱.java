class Solution_JoyStick {
    public int solution(String name) {
        int answer = 0;
        int leftRight = name.length() - 1; // 좌우이동 횟수 담을 변수. 기본값으로 글자수만큼 넣어둠
        // A는 65, Z는 90, N은 78(중간)
        // int intA = 'A';
        // int intB = 'Z';
        // char charC = 65;
        // char charD = 90;
        double mid = (65.0 + 90.0) / 2; // .0 붙여야 소수점까지나옴
        //System.out.print(intA+", "+intB+", "+charC+", "+charD+", "+mid);
        
        for(int i = 0; i < name.length(); i++) {
            int cha = name.charAt(i);
//             if(cha==65){ // A이면
//                 int front = i; // A 앞의 문자 개수
//                 int numberOfA=1; // 연속된 A의 개수
//                 if(name.charAt(i+1) == 65){ 
//                     for(int j = i+1; j<name.length();j++){
//                         if(name.charAt(j)==65) numberOfA++;
//                     }
//                     if(numberOfA+front==name.length())
//                 }
//                 int back = name.length()-back; // A 뒤의 문자 개수
//                 if(back+1 >front){ // A 뒤의 문자가 앞의 문자보다 많으면
                    
//                 }
//             }
//             answer++; // 옆으로 이동
            if(cha < mid) // = cha < 'N'
                answer += cha - 65; // = cha-'A'
            else
                answer += 1 + 90 - cha;

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') { // 이 다음 문자가 A이면
                next++;
            }
            // 
            int lastA = name.length()-next; // 연속된 A의 마지막 인덱스
            int move = i + Math.min(i, lastA) + lastA;
            leftRight = Math.min(leftRight, move);
        }
        return answer + leftRight;
    }
}

public class 조이스틱 {
    public static void main(String[] args) {
        Solution_JoyStick sol = new Solution_JoyStick();
        String name = "JAN";
        sol.solution(name);
    }
}