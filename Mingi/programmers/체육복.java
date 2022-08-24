class Solution {

    static int[] student;

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        init(n);

        lost_s(lost);

        reserve_s(reserve);

        check_s();

        for(int i = 0; i < student.length; i++){
            if(student[i] >= 1) answer++;
        }
        System.out.println(answer);

        return answer;
    }
    
    static void init(int n){
        student = new int[n];
        for(int i = 0; i < student.length; i++){
            student[i] = 1;
        }
    }

    static void lost_s(int[] lost){
        for(int i = 0; i < lost.length; i++){
            student[lost[i] - 1] = 0;
        }
    }

    static void reserve_s(int[] reserve){
        for(int i = 0; i < reserve.length; i++){
            student[reserve[i] - 1]++;
        }
    }

    static void check_s(){
        for(int i = 0; i < student.length; i++){
            if(student[i] == 0){
                if(i != 0 && student[i -1] == 2) {
                    student[i-1]--;
                    student[i]++;
                }

                else if(i != student.length-1 && student[i+1] == 2){
                    student[i+1]--;
                    student[i]++;
                }
            }
        }
    }
}

public class 체육복 {
    public static void main(String[] args){
        Solution s = new Solution();

        // int [] l1 = {2, 4};
        // int [] r1 = {1, 3, 5};

        // s.solution(5, l1, r1);

        // int [] l2 = {2, 4};
        // int [] r2 = {3};

        // s.solution(5, l2, r2);

        int [] l3 = {3};
        int [] r3 = {1};

        s.solution(3, l3, r3);
    }
}


