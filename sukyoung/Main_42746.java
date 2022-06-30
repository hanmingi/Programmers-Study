import java.util.*;

public class Main_42746{

    public String solution(int[] numbers) {
        String answer ="";        
        String [] result = new String[numbers.length];
        for(int i=0; i<numbers.length;i++){
            result[i]=String.valueOf(numbers[i]);    //한자리수로 만 문제가나오면 string으로 바꿀필요없지만 두자리이상부터는 앞자리로 비교를 해야해서 문자열로 바꾼다.
        }
        
        Arrays.sort(result,new Comparator<String>(){  //comparator 인스턴스 생성하기
            @Override  //compare메소드를 오버라이드해서 부모클래스로부터 상속받은 compare메소드를 재정의하려고 
            public int compare(String o1,String o2){
                return ((o2+o1).compareTo(o1+o2));    //상속받은 compare메소드를 재정의 해서 내가원하는 식으로 return 만듬
            }
        });
        
        if(result[0].equals("0")){     // 예를들어 0으로만 이루어진 숫자를 주어지면 000이 아닌 0으로 나와야하기때문에 "0" 으로 리턴해준다
            return "0";
        }
        
        for(String a:result){   //a는 대입받을 변수정의를 해주고 result(배열명)으로 for문 돌려서 답answer만들기
            answer +=a;
        }
        return answer;
    }
}
