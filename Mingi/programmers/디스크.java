package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        Solution_디스크 s = new Solution_디스크();

        System.out.println(s.solution(jobs));
    }
}
class Solution_디스크 {
    class Job {
        int requestTime;
        int spendTime;

        Job(int requestTime, int spendTime) {
            this.requestTime = requestTime;
            this.spendTime = spendTime;
        }

        int getSpendTime() { return spendTime; }
        int getRequestTime() { return requestTime; }
    }
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,
                Comparator
                        .<int[]>comparingInt(a -> a[0])
                        .<int[]>thenComparingInt(b -> b[1])
        );

        Queue<Job> pq = new PriorityQueue<>(jobs.length,
                Comparator.comparingInt(Job::getSpendTime));

        pq.add(new Job(jobs[0][0], jobs[0][1]));
        int elapsedTime = jobs[0][0];
        int index = 1;
        int waitSum = 0;
        while (index < jobs.length || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                pq.add(new Job(jobs[index][0], jobs[index][1]));
                elapsedTime = jobs[index][0];
                index++;
            }

            Job job = pq.poll();
            elapsedTime += job.getSpendTime();
            waitSum = waitSum + (elapsedTime - job.getRequestTime());

            while (index < jobs.length
                    && jobs[index][0] <= elapsedTime) {
                pq.add(new Job(jobs[index][0], jobs[index][1]));
                index++;
            }
        }

        int answer = waitSum / jobs.length;
        return answer;
    }
}