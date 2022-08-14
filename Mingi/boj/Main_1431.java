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
                if(o1.length() < o2.length()){
                    return -1;
                }
                else if(o1.length() == o2.length()){
                    if(add(o1) == add(o2)){
                        return o1.compareTo(o2);
                    }
                    else{
                        return Integer.compare(add(o1), add(o2));
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
                sum += s.charAt(i) - '0';   
            }
        }
        return sum;
    }
}
