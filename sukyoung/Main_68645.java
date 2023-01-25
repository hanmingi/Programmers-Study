class Solution {
    public int[] solution(int n) {

		int[][] temp = new int[n][n];
		int p = n;
		int x = -1; 
		int y = 0; 
		int num = 1;
        int sum = 0;
        
        for(int i=1; i<=n; i++){
            sum+=i;
        }
        int[] answer = new int[sum];
		
		while(n>0){
            for(int i=0; i<n; i++){
                x++;
                temp[x][y] = num;
                num++;
            }
            n--;
            if(n==0)
                break;

            for(int i=0; i<n; i++){
                y++;
                temp[x][y] = num;
                num++;
            }
            n--;
            if(n==0)
                break;

            for(int i=0; i<n; i++){
                x--;
                y--;
                temp[x][y] = num;
                num++;
            }
            n--;
            if(n==0)
                break;
        }
        
		int q =0;
		for(int i =0; i < p; i++) {
			for(int j =0; j <=i; j++) {
				answer[q] = temp[i][j];
                q++;
			}
		}
        return answer;
    }
}
