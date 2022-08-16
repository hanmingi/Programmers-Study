class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){

            String temp = "";

            int[] a1 = check(n, arr1[i]);
            int[] a2 = check(n, arr2[i]);

            for(int j = 0; j < n; j++){
                if(a1[j] == 0 && a2[j] == 0) temp += " ";
                else temp += "#"; 
            }

            answer[i] = temp;
        }
        return answer;
    }

    static int[] check(int n, int target){
        int[] answer = new int[n];
        int idx = n - 1;
        while(target != 0){
            answer[idx] = target % 2;
            target /= 2;
            idx--;
        }

        while(idx >=0){
            answer[idx] = 0;
            idx--;
        }

        return answer;
    }
}

public class 비밀지도 {
    public static void main(String[] args){
        Solution s = new Solution();

        int[] t1 = {9, 20, 28, 18, 11};
        int[] t2 = {30, 1, 21, 17, 28};


        String[] answer = s.solution(5, t1, t2);

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
