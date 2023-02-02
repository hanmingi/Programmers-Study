class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(int i=0;i<=d;i=i+k) {
            long x = (long)Math.pow(i, 2);
            long distance = (long)Math.pow(d, 2);
            int y = (int) Math.sqrt(distance - x);
            answer =answer + (y/k) + 1;
        }
        return answer;
    }
}
