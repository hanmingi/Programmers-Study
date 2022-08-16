//S : 1
//D : 2
//T : 3

// * : 이전 점수, 현재 점수 * 2
// # : 획득 점수 * -1


class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        String temp = "";
        int[] arr = new int[3];

        for(int i = 0; i < dartResult.length(); i++){
            switch(dartResult.charAt(i)){
                case '*':
                    arr[index - 1] *= 2;
                    if(index > 1) arr[index - 2] *= 2;
                    break;

                case '#':
                    arr[index -1] *= -1;
                    break;

                case 'S':
                    arr[index] = (int)Math.pow(Integer.parseInt(temp), 1);
                    index++;
                    temp = "";
                    break;

                case 'D':
                    arr[index] = (int)Math.pow(Integer.parseInt(temp), 2);
                    index++;
                    temp = "";
                    break;

                case 'T':
                    arr[index] = (int)Math.pow(Integer.parseInt(temp), 3);
                    index++;
                    temp = "";
                    break;

                default:
                    temp += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }

        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }

        return answer;
    }
}

public class 다트게임 {
    public static void main(String[] args){

        Solution s = new Solution();

        System.out.println(s.solution("1S2D*3T")); //37

        System.out.println(s.solution("1D2S#10S")); //9

        System.out.println(s.solution("1D2S0T")); //3

        System.out.println(s.solution("1S*2T*3S")); //23

        System.out.println(s.solution("1D#2S*3S")); //5

        System.out.println(s.solution("1T2D3D#")); //-4

        System.out.println(s.solution("1D2S3T*")); //59
    }
}
