import java.util.*;

class Solution_parking {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> inTime = new HashMap<String, String>(); // 입차시간
        HashMap<String, Integer> parkingTime = new HashMap<String, Integer>(); // 주차누적시간(출차시간-입차시간)

        for (int i = 0; i < records.length; i++) {
            String temp[] = records[i].split(" ");
            if (temp[2].equals("IN")) {
                inTime.put(temp[1], temp[0]); // 차량번호, 입차시간 순으로 넣음
            } else {
                String timeIn[] = inTime.get(temp[1]).split(":");
                inTime.remove(temp[1]);
                String timeOut[] = temp[0].split(":");
                int min = 0;
                min += (Integer.parseInt(timeOut[0]) - Integer.parseInt(timeIn[0])) * 60;
                min += Integer.parseInt(timeOut[1]) - Integer.parseInt(timeIn[1]);
                if (parkingTime.containsKey(temp[1])) { // 주차요금 산정된 맵에 이미 해당 차량이 들어가 있으면
                    parkingTime.replace(temp[1], parkingTime.get(temp[1]) + min); // 이미 들어있는 시간에 플러스
                } else { // 맵에 없으면
                    parkingTime.put(temp[1], min); // 새로 넣기
                }
            }
        }
        // 출차 기록이 없는 차들은 23:59 출차로 주차 누적시간 기록
        for (String s : inTime.keySet()) {
            String[] timeIn = inTime.get(s).split(":");
            int min = 0;
            min += (23 - Integer.parseInt(timeIn[0])) * 60;
            min += 59 - Integer.parseInt(timeIn[1]);
            if (parkingTime.containsKey(s)) {
                parkingTime.replace(s, parkingTime.get(s) + min);
            } else {
                parkingTime.put(s, min);
            }
        }
        Object[] sortedCar = parkingTime.keySet().toArray(); // 차 번호 순서대로 정렬
        Arrays.sort(sortedCar);
        int[] answer = new int[sortedCar.length];
        for (int i = 0; i < sortedCar.length; i++) { // 주차 요금 계산
            int timeUnpaid = parkingTime.get(sortedCar[i]);
            int fee = 0;
            if (timeUnpaid >= fees[0]) { // 기본 시간 넘으면
                timeUnpaid -= fees[0]; // 추가로 계산할 금액은 기본 시간 제외한 시간으로 계산
                fee = fees[1]; // 기본요금 내기
            } else { // 기본 시간 안 넘으면
                timeUnpaid = 0; // 추가로 계산할 금액 없음
                fee = fees[1]; // 기본요금 내기
            }
            if (timeUnpaid > 0) { // 기본 시간 제외한 시간 계산
                if (timeUnpaid % fees[2] == 0) {
                    fee += timeUnpaid / fees[2] * fees[3];
                } else {
                    fee += (timeUnpaid / fees[2] + 1) * fees[3];
                }
            }
            answer[i] = fee;
        }
        return answer;
    }
}

public class parking {
    public static void main(String[] args) {
        Solution_parking s = new Solution_parking();
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
        int[] fees = { 180, 5000, 10, 600 };
        int[] answer = s.solution(fees, records);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}