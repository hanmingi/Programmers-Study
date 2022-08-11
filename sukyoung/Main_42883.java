import java.util.*;

public class Main_42883 {

        public String solution(String number, int k) {
            int index = 0;
            int max = 0;
            String answermax="";
            for(int i=0; i<number.length() - k; i++) {  //예를들어 3개이면 2개를제외하고 먼저 앞에를 비교해줘야한다.이유는 만약맨끝에 큰수가나오면 나머지것은 찾을수가없다.
                max = 0;
                for(int j = index; j<= k+i; j++) {
                    if(max < number.charAt(j)-'0') {
                        max = number.charAt(j)-'0';
                        index = j+1;
                    }
                    if((number.charAt(j)-'0')==9){      //시간초과가 계속뜨는데 9일경우 바로 최대값9를 넣어서 바로 종료하면 시간초과가 안뜹니다.
                        max=9;
                        index = j+1;
                        break;
                    }
                }
                answermax +=Integer.toString(max);      //MAX는 INT형이기때문에 STRING으로 바꿔서 더해준다.
            }
            return answermax;
        }

}