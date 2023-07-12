class Solution {
    public int solution(int[] a) {  
        int[] left= new int[a.length];
        int[] right= new int[a.length];
        int answer= 2;
        int val= a[0];   

        for(int i = 1; i < a.length-1; i++)   //왼쪽최소구하기
        {
            if(val > a[i])
            {
                val= a[i];
            }
            left[i]= val;
        }

        int val2 = a[a.length-1];           
        for(int i = a.length-2; i > 0; i--)  //오른쬭 최소구하기
        {
            if(val2 > a[i])
            {
                val2= a[i];
            }
            right[i] = val2;
        }

        for(int i = 1; i < a.length-1; i++)  //양쪽끝에는무조건되니 그거 빼고 돌려서 구하기
        {
            if(a[i] <= left[i] || a[i] <= right[i])     //양쪽둘다최소보다 작으면 안뎀 그러면 작은풍선터트리기 2번써야함
            {
                answer++;
            }
        }
        return answer;
    }
}
