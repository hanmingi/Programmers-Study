package programmers;

public class 풍선터트리기 {
    public static void main(String[] args) {
        Solution_풍선 s = new Solution_풍선();

        System.out.println(s.solution(new int[]{9, -1, -5}));
    }
}

class Solution_풍선 {
    public int solution(int[] a) {
        int answer = 0;

        if(a.length == 1) return 1;
        if(a.length == 2) return 2;

        int leftMin = a[0];
        int[] rightMin = new int[a.length];

        rightMin[a.length - 1] = a[a.length - 1];

        //System.out.println("a = " + Arrays.toString(a));
        //System.out.println("rightMin = " + Arrays.toString(rightMin));

        for(int i = a.length - 2; i > 0; i--){
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        //System.out.println("rightMin = " + Arrays.toString(rightMin));

        for(int i = 0; i < a.length; i++){

            //System.out.println("leftMin = " + leftMin);
            //System.out.println("a[i] = " + a[i]);
            //System.out.println("rightMin = " + rightMin[i]);

            if(!(leftMin < a[i] && rightMin[i] < a[i])) answer++;
            leftMin = Math.min(leftMin, a[i]);
        }
        return answer;
    }
}