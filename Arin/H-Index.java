import java.util.Arrays;

class H-Index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] cit = {3, 0, 6, 1, 5};
        Solution so = new Solution();
        System.out.println(so.solution(cit));        
    }
}
