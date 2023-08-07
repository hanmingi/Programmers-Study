package sukyoung;

import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k != 1) {
            if(k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            list.add(k);
        }

        List<Double> wid = new ArrayList<>();
        for(int i = 0; i < list.size() -1; i++) {
            double eachwid = ((double) list.get(i) + list.get(i + 1)) / 2;  //타입맞춰줘야함 
            wid.add(eachwid);
        }

        double[] answer = new double[ranges.length];
        int n = 0;
        double sum = 0;
        for(int[] arr : ranges) {
            if(arr[0] > wid.size() + arr[1]) {  //arr[1]이 arr[0]보다 더커서 넘어가면 -1반환
                answer[n++] = -1.0;
                continue;
            }
            for(int j = arr[0]; j < wid.size() + arr[1]; j++) { //예를들어 범위가 계산시에 3,3 같아서 0이나와야할때는 for문안돔 sum은 어차피 0
                sum += wid.get(j);
            }
            answer[n++] = sum;
            sum =0;
        }
        return answer;
    }
}
