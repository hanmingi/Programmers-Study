import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int p = arrayA[0];  //맨앞의 약수를 가지고 있어야 일단 뒤에것들도 다 나누어짐
        int q = arrayB[0];
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= p; i++) { //1은 어느한경우에도 되니까 빼야함
            if(p % i == 0) set.add(i);
        }
        for(int i = 2; i <= q; i++) {
            if(q % i == 0) set.add(i);
        }
        
        List<Integer> list = new ArrayList<>(set);
        for(int k = 0; k < list.size(); k++) {
            boolean chk = true;
            for(int i = 0; i < arrayA.length; i++) {
                if(arrayA[i] % list.get(k) != 0 || arrayB[i] % list.get(k) == 0) {
                    chk = false;
                    break;
                }
            }
            if(chk) answer = Math.max(answer, list.get(k));

            chk = true;
            for(int i = 0; i < arrayB.length; i++) {
                if(arrayB[i] % list.get(k) != 0 || arrayA[i] % list.get(k) == 0) {
                    chk = false;
                    break;
                }
            }
            if(chk) answer = Math.max(answer, list.get(k));
        }
        return answer;
    }
}


//실패 이유: &&써서 비교하면 [10,17]   [5,27]  경우에 10을 넣었을 때 만족하지마 10자체가 10 17 의 약수가 아니기때문  
// import java.util.*;
// class Solution {
//     public int solution(int[] arrayA, int[] arrayB) {
//         int answer = 0;
//         Arrays.sort(arrayA);
//         Arrays.sort(arrayB);
//         ArrayList<Integer> naA = new ArrayList<>();
//         ArrayList<Integer> naB = new ArrayList<>();
//         for(int i = 1; i<=arrayA[0];i++){
//             if((arrayA[0] % i )==0){
//                 naA.add(i);
//             }
//         }
//         for(int i = 1; i<=arrayB[0];i++){
//             if((arrayA[B] % i )==0){
//                 naB.add(i);
//             }
//         }
//         for(int i = 0;i<arrayB.length;i++){
//             for(int j =0;j<naA.size();j++){
//                 if((((arrayB[i])%naA.get(j)) !=0) && (((arrayA[i])%naA.get(j))==0)){
//                     answer = naA.get(j);
//                 }
//             }
//         }
//         for(int i = 0;i<arrayA.length;i++){
//             for(int j =0;j<naB.size();j++){
//                 if((((arrayA[i])%naB.get(j)) !=0) && (((arrayB[i])%naB.get(j))==0)){
//                     answer = naB.get(j);
//                 }
//             }
//         }	
//         return answer;
//     }
// }
