class Solution_NumCardDist {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 각 배열의 최대공약수 구하기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);
            gcdB = getGcd(gcdB, arrayB[i]);
        }

        // 구한 최대공약수로 서로의 배열을 나눌 수 없는지 확인하여 나눌 수 없으면 answer에 담기
        if (ifDivisible(arrayB, gcdA) == false) // = A배열의 최대공약수로 B배열의 숫자들을 나눌 수 없다
            if (answer < gcdA) // answer 중에서도 최대값 넣기
                answer = gcdA;
        if (ifDivisible(arrayA, gcdB) == false) // = B배열의 최대공약수로 A배열의 숫자들을 나눌 수 없다
            if (answer < gcdB)
                answer = gcdB;

        return answer;
    }

    // 두 수가 주어지고, 최대공약수 리턴
    public int getGcd(int a, int b) {
        if (a % b == 0)
            return b;
        return getGcd(b, a % b);
    }

    // 정수 배열 arr과 정수 gcd가 주어지고, gcd로 arr배열 안 정수 하나라도 나눠지는지 여부를 리턴
    public boolean ifDivisible(int[] arr, int gcd) {
        for (int ar : arr)
            if (ar % gcd == 0)
                return true;
        return false;
    }
}

public class 숫자카드나누기 {
    public static void main(String[] args) {
        Solution_NumCardDist sol = new Solution_NumCardDist();
        int[] arrayA = { 14, 35, 119 };
        int[] arrayB = { 18, 30, 102 };
        sol.solution(arrayA, arrayB);
    }
}