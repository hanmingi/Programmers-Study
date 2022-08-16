import java.util.Arrays;

class Solution_NoK { // K번째수
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; //commands 개수만큼 배열 크기 설정
        int n = 0;
        
        for(int i = 0; i < commands.length; i++){
            int k = 0;

            int[] list = new int[commands[i][1]-commands[i][0] + 1]; //commands가 [2, 5, 3]일 때 5-2+1로 list배열 크기 설정
            
            for(int j = commands[i][0]; j <= commands[i][1]; j++) { //commands가 [2, 5, 3]일 때 array의 2번째부터 5번째까지 값을 list에 담는다
                list[k++] = array[j-1];
            }
            Arrays.sort(list); // Arrays.sort() : 배열 오름차순 정렬
            answer[n++] = list[commands[i][2]-1]; // answer배열에 list배열의 3번째 숫자를 담는다.

        }
        return answer;
    }
}
