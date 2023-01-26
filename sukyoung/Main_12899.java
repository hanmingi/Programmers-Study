class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int p = n%3;

            if(p == 0) {
                sb.append(4);
            } else if(p == 1) {
                sb.append(1);
            } else {
                sb.append(2);
            }
            if(p == 0)  {
                n = n - 1;
            }
            n = n / 3;
        }

        return sb.reverse().toString();
    }
}
