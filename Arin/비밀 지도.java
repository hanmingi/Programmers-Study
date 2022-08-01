class Solution_secretMap { //비밀 지도
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        String[] arr1Binary = changeToBinary(arr1); //int배열의 숫자들을 이진수로 바꾸고 String배열로 바꿈. arr1={9, 20, 28, 18, 11} -> arr1Binary={"01001", "10100", "11100", "10010", "01011"}
        String[] arr2Binary = changeToBinary(arr2);

        for (int i = 0; i < n; i++) {
            String answerElement = ""; // "#" 또는 " " 들어갈 변수
            for (int j = 0; j < n; j++) {
                char a1 = arr1Binary[i].charAt(j); //0 또는 1
                char a2 = arr2Binary[i].charAt(j);
                if (a1 == '0' && a2 == '0') { // 두 배열의 같은 위치에 모두 0이면 " " 담음
                    answerElement += " ";
                } else { //하나라도 0이 아니면 "#" 담음
                    answerElement += "#";
                }
            }
            answer[i] = answerElement;
        }

        return answer;
    }

    //int배열 받아서 이진수로 바꿔 String배열로 바꿔주는 메서드
    public String[] changeToBinary(int[] arr) {
        String[] arrBinary = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String binaryy = ""; // 이진수
            // arr1의 각 숫자들을 이진수로 바꾸기
            // ex) {9, 20, 28, 18, 11} -> {01001, 10100, 11100, 10010, 01011}
            int quotientt = arr[i]; // 몫
            for (int j = 0; j < arr.length; j++) {
                // ex) 10진수 9를 2진수로 바꿔보자
                // 맨 처음 수 9을 2로 나눈 나머지값1과 몫4 저장 -> 몫4를 2로 나눈 나머지값0과 몫2 저장 ->
                // 몫2를 2로 나눈 나머지값0과 몫1 저장 -> 몫1을 2로 나눈 나머지값1 몫0 저장 -> 몫0 되면 끝
                while (quotientt > 0) {
                    int remainderr = quotientt % 2; // 나머지 담기
                    binaryy = remainderr + binaryy; // 이진수에 나머지값 저장(문자열 앞에 넣기)
                    quotientt /= 2; // 나누기한 몫 담기
                }
            }

            // 변환한 이진수의 자리수가 주어진 n(arr길이)보다 짧을 때 앞을 0으로 채우기
            while(binaryy.length() < arr.length){
                binaryy = "0" + binaryy;
            }

            arrBinary[i] = binaryy;
        }
        return arrBinary;
    }

    // public static void main(String[] args) {
    //     Solution_secretMap so = new Solution_secretMap();
    //     int n = 5;
    //     int[] arr1 = { 9, 20, 28, 18, 11 };
    //     int[] arr2 = { 30, 1, 21, 17, 28 };
    //     String[] answer = so.solution(n, arr1, arr2);
    //     for (int i = 0; i < answer.length; i++) {
    //         System.out.println(answer[i] + " / ");
    //     }
    // }
}
