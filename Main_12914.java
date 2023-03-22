class Solution {    
    public long solution(int n) {
        int[] p = new int[n+2];  //n+1을 하면 안되는데 아마 생각이지만 메모리초과같습니다.
        p[1] = 1;
        p[2] = 2;
      
        if(n==1){
            return p[1];
        }
        else if(n==2){
            return p[2];
        }
        else{
            for(int i = 3; i <= n; i++){
                p[i] = (p[i-1] + p[i-2])%1234567;
            }
            return p[n];
        }
    }
}


// class Solution {
//     public int N;
//     public long result = 0;
//     public int dp[] = new int[2001];

//     public long solution(int n) {
//         long answer = 0;

//         for (int i = 0; i < 2001; i++) {
//             dp[i] = 0;
//         }
//         N = n;
//         result = dfs(0);
//         return result;
//     }

//     public int dfs(int sum) {
//         if (dp[sum] != 0) {
//             return dp[sum];
//         }
//         if (sum == N) {
//             return 1;
//         }
//         if (sum > N) {
//             return 0;
//         }
//         return dp[sum] = (n1 + n2) % 1234567;
//     }
// }
