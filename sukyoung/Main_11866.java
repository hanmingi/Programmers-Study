import java.util.*;

public class Main_11866 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int k = in.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		
		for(int i = 1; i <= p; i++) {
			q.add(i);
		}
		
		String answer="<";
		while(q.size() > 1) {

			for(int i = 0; i < k-1; i++) {
				int val = q.poll();
				q.offer(val);
			}
            int val2=q.poll();
            String a=String.valueOf(val2);
			answer=answer+a+",";
		}
        int val3=q.poll();

        String b=String.valueOf(val3);
        answer=answer+b+">";
		System.out.println(answer);
    }
}
