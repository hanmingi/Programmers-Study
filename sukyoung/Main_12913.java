import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        answer= Math.max(Math.max(land[land.length-1][0], land[land.length-1][1]), Math.max(land[land.length-1][2], land[land.length-1][3]));
        return answer;
    }
}

// class Solution {
//     int solution(int[][] land) {
//         int sum = 0;
//         int max = 0;
//         int p = 0;
//         int [][] k = new int [land.length][4];
//         for(int j=0; j<4;j++){
//             if(max<land[0][j]){
//                 max= land[0][j];
//                 p=j;
//             }            
//         }

//         sum =sum+max;
//         max=0;
//         for(int i=1; i<land.length;i++){
//             land[i][p]=0;
//             for(int j=0;j<4;j++){
//                 if(max<land[i][j]){
//                     max=land[i][j];
//                     p=j;
//                 }
//             }
//             sum= sum+max;
//             max=0;
//         }
//         return sum;
//     }
// }
// =========================================================================================

// class Solution {
//     int solution(int[][] land) {
//         int [][]boksa =new int [land.length][land[0].length];
//         for(int i=0;i<land.length;i++){
//             boksa[i]=land[i].clone();
//         }
//         int answer=0;
//         int sum = 0;
//         int sum1= 0;
//         int max = 0;
//         int max1= 0;
//         int p = 0;
//         int q = 0;
//         int [][] k = new int [land.length][4];
//         for(int j=0; j<4;j++){
//             if(max<land[0][j]){
//                 max= land[0][j];
//                 p=j;
//             }            
//         }
//         sum =sum+max;
//         //System.out.print(max);
//         max=0;
//         land[0][p]=0;
//         for(int j=0; j<4;j++){
//             if(max1<land[0][j]){
//                 max1= land[0][j];
//                 q=j;
//             }            
//         }
//         //System.out.println(max1);
//         sum1=max1;
//         max1=0;
//         for(int i=1; i<land.length;i++){
//             land[i][q]=0;
//             for(int j=0;j<4;j++){
//                 if(max1<land[i][j]){
//                     max1=land[i][j];
//                     q=j;
//                 }
//             }
//             boksa[i][p]=0;
//             for(int j=0;j<4;j++){
//                 if(max<boksa[i][j]){
//                     max=boksa[i][j];
//                     p=j;
//                 }
//             }
//             sum1=sum1+max1;
//             sum= sum+max;
//             max=0;
//             max1=0;
            
            
//         }
//         System.out.println(sum);
//         System.out.println(sum1);
//         if(sum1>sum){
//                 answer=sum1;
//             }else{
//                 answer=sum;
//             }
//         return answer;
//     }
// }
