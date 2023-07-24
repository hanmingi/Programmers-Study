package LV3;


import java.util.HashSet;

public class BallonBreaker {
    public int solution(int[] a) {
        int answer = 0;

        int left_min = Integer.MAX_VALUE;
        int right_min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i<a.length ; i++)
        {
            left_min = Math.min(left_min,a[i]);
            right_min = Math.min(right_min,a[a.length-i-1]);
            set.add(left_min);
            set.add(right_min);
        }
        answer = set.size();
        return answer;
    }


    //시간초과!
    public int solution2(int[] a) {
        int answer = 0;
        for(int i = 0 ; i<a.length ; i++)
        {    
            int left_min = a[0];
            int right_min = a[a.length-1];
            int nowCell = a[i];
            //left
            for(int leftIdx = 0 ; leftIdx < i ; leftIdx++)
            {
                left_min = Math.min(left_min, a[leftIdx]);
            }
            //right
            for(int rightIdx =a.length-1; rightIdx>i ; rightIdx--)
            {
                right_min = Math.min(right_min, a[rightIdx]);
            }

            System.out.println(left_min + " < " + a[i] + " < " + right_min);

            if( left_min <= a[i] == true  &&
                a[i] <= right_min == true
              )
            {
                // System.out.println("-------------------------------");
                 System.out.println("cel!! " + a[i]);
                // System.out.println("-------------------------------");
                answer++;
            }

            //찬스를 2번째로 쓸경우
            else if(Math.min(Math.min(left_min, right_min), nowCell) == nowCell)
            {
                answer++;
                System.out.println("cell2!! " + a[i]);
            }
            
            //찬스를 먼저 쓸경우
            else if(Math.max(right_min, (Math.min(left_min, nowCell))) == nowCell)
            {
                answer++;
                System.out.println("cell3!! " + a[i]);
            }
        }    

        return answer;
    }
    
}
