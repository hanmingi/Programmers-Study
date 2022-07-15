import java.util.*;

public class Main_1431 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() < o2.length()){              //첫번째 if else문은 길이에 따라서 -1.0.1.반환
                    return -1;
                }
                else if(o1.length() == o2.length()){
                    if(add(o1) == add(o2)){                     //두번째 if문은 먼저 add함수로 숫자만의 길이가 같으면  string형태로 사전순으로 먼저온다
                        return o1.compareTo(o2);
                    }
                    else{                                           
                        Integer a1=new Integer(add(o1));            //여기서는 2번째 조건 모든 자리 숫자합으로 비교해서 작은합이 먼저온다.
                        
                        return a1.compareTo(add(o2));
                    }
                }
                else{
                    return 1;
                }
            }
        });

        for(String i : arr){
            System.out.println(i);
        }
    }
    
    static int add(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sum += s.charAt(i) - '0';                          // 여기서 '0'은 48 '9' 는 57의미한다(아스키코드).
            }
        }
        return sum;
    }
}