class Solution_dart {
    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        char[] dartResultArr = dartResult.toCharArray();
        String a = "";
        int[] number = new int[3];

        for (int i = 0; i < dartResultArr.length; i++) {
            switch (dartResultArr[i]) {
                case 'S':
                    number[index] = Integer.parseInt(a);
                    index++;
                    a = "";
                    break;
                case 'D':
                    number[index] = (int) Math.pow(Integer.parseInt(a), 2);
                    index++;
                    a = "";
                    break;
                case 'T':
                    number[index] = (int) Math.pow(Integer.parseInt(a), 3);
                    index++;
                    a = "";
                    break;

                case '*':
                    number[index - 1] *= 2;
                    if (index - 1 != 0)
                        number[index - 2] *= 2;
                    break;

                case '#':
                    number[index - 1] *= -1;
                    break;

                default:
                    a += dartResultArr[i];
                    break;
            }
        }

        for (int i = 0; i < number.length; i++) {
            answer += number[i];
        }

        return answer;
    }

}

public class 다트게임 { // 다트 게임
    public static void main(String[] args) {

        Solution_dart s = new Solution_dart();
        System.out.println(s.solution("1S2D*3T")); // 37
        System.out.println(s.solution("1D2S#10S")); // 9
        System.out.println(s.solution("1D2S0T")); // 3
        System.out.println(s.solution("1S*2T*3S")); // 23
        System.out.println(s.solution("1D#2S*3S")); // 5
        System.out.println(s.solution("1T2D3D#")); // -4
        System.out.println(s.solution("1D2S3T*")); // 59
    }
}