import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> a = new PriorityQueue<>();
		
        for (int i = 0; i < scoville.length; i++) {
			a.add(scoville[i]);
		} 
		
        while (a.peek() < K) {
			if (a.size() < 2) {
				return -1;
			}
			int b = a.poll();
			int c = a.poll();
			a.add(b+2*c);
			answer++;
		}
		return answer;
	}
}
