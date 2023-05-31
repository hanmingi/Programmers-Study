import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0; 
        long total = 0;
        int p = 0;
        long k = 0;
        Arrays.sort(weights);
        HashMap<Integer, Integer> q = new HashMap<>();
        for (int i : weights) {
            q.put(i, q.getOrDefault(i, 0) +1);
        }
        int [] weightsch = new int [q.size()]; 
        //System.out.println(q.size());
        
        for ( Integer key : q.keySet() ) {
            weightsch[p]=key;
            if(q.get(key) != 1){
                for(int i = 1 ;i<q.get(key); i++){
                    total =((long)(total + i));
                }
                answer= answer+total;
            }
            p++;
            total=0;
        }
        System.out.println(answer);
        Arrays.sort(weightsch);
        // System.out.println(weightsch[0]);
        // System.out.println(weightsch[1]);
        for (int i = 0; i < weightsch.length-1; i++) {
            for (int j = i + 1; j < weightsch.length; j++) {
                if ( ((weightsch[j]*2) == (weightsch[i] * 3)) || ((weightsch[j]*3) == (weightsch[i] * 4)) || (weightsch[j]*2 == (weightsch[i] * 4))) {
                   // k=((long)(q.get(weightsch[i])*q.get(weightsch[j])));
                     k=((long)(q.get(weightsch[i]))*(long)(q.get(weightsch[j])));
                    answer= answer+k;
                }
            }
        }
        //System.out.println(k);
        return answer;
    }
}

//시간초과
// import java.util.Arrays;

// class Solution {

//     public long solution(int[] weights) {
//         long answer = 0;

//         Arrays.sort(weights);

//         for (int i = 0; i < weights.length; i++) {
//             int prev = weights[i];
//             for (int j = i + 1; j < weights.length; j++) {
//                 if (weights[j] == prev || (weights[j] == (prev * 3) / 2) || (weights[j] == (prev * 4) / 3)
//             || (weights[j] == (prev * 2))) {
//                     answer++;
//                 }
//             }
//         }

//         return answer;
//     }
// }
