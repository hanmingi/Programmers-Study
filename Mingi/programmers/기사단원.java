package programmers;//package develope;

//https://school.programmers.co.kr/learn/courses/30/lessons/136798

public class 기사단원 {
    public static void main(String[] args) {
        int n1 = 5;
        int l1 = 3;
        int p1 = 2;
        //result = 10

        int n2 = 10;
        int l2 = 3;
        int p2 = 2;
        //result = 21
        Solution_기사단원 s = new Solution_기사단원();

        System.out.println(s.solution(n1, l1, p1));
        System.out.println(s.solution(n2, l2, p2));
    }
}

class Solution_기사단원 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        int[] people = new int[number];

        for(int i = 0; i < number; i++){
            people[i] = count(i + 1);

            if(people[i] > limit) people[i] = power;

            answer += people[i];
        }
        return answer;
    }

    static int count(int n){
        int count = 0;

        for(int i = 1; i * i <= n; i++){
            if(i * i == n) count++;
            else if(n % i == 0) count +=2 ;
        }

        return count;
    }
}