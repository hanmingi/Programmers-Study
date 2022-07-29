import java.util.*;


public class Main_17682  {
    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        String temp = "";
        int[] arr = new int[3];                 //계산해서 더해줄수 있는 배열 3개 만들기

        for(int i = 0; i < dartResult.length(); i++){
            switch(dartResult.charAt(i)){
                case '*':
                    arr[index - 1] *= 2;
                    if(index > 1) arr[index - 2] *= 2;              //이부분은 index가 첫번째가 아닌 두번째 세번째이면 그전에것도 2배 해줄수 있기 때문에 
                    break;

                case '#':
                    arr[index -1] *= -1;
                    break;

                case 'S':
                    arr[index] = (int)Math.pow(Integer.parseInt(temp), 1);      //(int) 이부분은 math.pow는 double형이기 때문에 arr[] int형으로 되어있어서 변환 해주어야함
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
                    break;                                              //항상 이부분이 먼저 숫자이므로 실행이 됨
            }
        }

        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }

        return answer;
    }

}
