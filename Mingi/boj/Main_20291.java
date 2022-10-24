//package develope;

import java.util.*;
import java.util.Map.Entry;

public class Main_20291{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> map = new TreeMap<>();

        // 테스트 케이스 수 입력
        int tc = sc.nextInt();

        for(int i = 0; i < tc; i++){
            String filename = sc.next();

            // . 기준으로 문자열 분리, .은 특수문자 처리이기 때문에 \\ 를 추가 해 주어야함.
            // 확장자는 무조건 . 뒤에 이다 보니 배열의 제일 끝 또는 [1] 번을 열면 된다.
            String[] split_filename = filename.split("\\.");

            if(map.containsKey(split_filename[1])){
                
                // 확장자 갯수 
                int count = map.get(split_filename[1]);
                
                // 1을 더해서 추가
                // 여기서 ++count 를 해주는 이유가 중요
                map.replace(split_filename[1], ++count);
            }

            // 없으면 초기값 1 선언
            else map.put(split_filename[1], 1);

        }

        for(Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}