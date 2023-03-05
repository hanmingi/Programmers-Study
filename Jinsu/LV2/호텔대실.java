/**
 * * <알고리즘 스터디 31회차 2023.03.02>
 *  LV2_호텔 대실 : https://school.programmers.co.kr/learn/courses/30/lessons/155651
호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.

제한사항
1 ≤ book_time의 길이 ≤ 1,000
book_time[i]는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
[대실 시작 시각, 대실 종료 시각] 형태입니다.
시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
예약 시각이 자정을 넘어가는 경우는 없습니다.
시작 시각은 항상 종료 시각보다 빠릅니다.
입출력 예
book_time	result
[["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]	3
[["09:10", "10:10"], ["10:20", "12:20"]]	1
[["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	3
입출력 예 설명
입출력 예 #1

example1
위 사진과 같습니다.

입출력 예 #2

첫 번째 손님이 10시 10분에 퇴실 후 10분간 청소한 뒤 두 번째 손님이 10시 20분에 입실하여 사용할 수 있으므로 방은 1개만 필요합니다.

입출력 예 #3

세 손님 모두 동일한 시간대를 예약했기 때문에 3개의 방이 필요합니다.

*/

package LV2;

public class HotelReservation {
    static int roomTimeTable[][] = new int[24][60];

    public int solution(String[][] book_time) {
        int answer = 0;
        for (int i = 0 ; i< 24 ; i++){
            for(int j = 0 ; j<60 ; j++){
                roomTimeTable[i][j] = 0;
            }
        }

        //1. 반복문 -> 2차원배열의 길이만큼
        for(int i = 0; i< book_time.length; i++){
            //2. StTime, EdTime int로 변경
            int[] iTime = timeStringToInt(book_time[i]);

            //3. timeTable 기입
            reservation(iTime[0], iTime[1]);

        }        
        
        //4. timeTable max값 출력
        // Arrays.sort(roomTimeTable);
        for(int i = 0 ; i< 24 ; i++){
            for(int j = 0 ; j<60 ; j++){
                if(answer < roomTimeTable[i][j])
                    answer = roomTimeTable[i][j];
            }
        }
        
        return answer;
    }

    //예약함수
    public int reservation(int startTime, int entTime){
        int startTime_Hour = startTime / 100;
        int startTime_Min = startTime % 100;

        int endTime_Hour = entTime / 100;
        int endTime_Min = entTime % 100;

        //청소시간 10분 추가
        endTime_Min += 10;
        //선처리(예외처리) 퇴실시간의 분이 51분+@ 일때, 청소시간 +10을 해주면 에러가남
        if(endTime_Min > 59){
            // System.out.println("edMin : " + endTime_Min);
            endTime_Min = endTime_Min - 60;
            endTime_Hour++;

            //23:59 고정
            if(endTime_Hour == 24){
                endTime_Hour = 23;
                endTime_Min = 59;
            }
        }

        //Case1. 같은시간 퇴실
        //ex-> 1500,1501,1502,1503,... 1550            
        if(startTime_Hour == endTime_Hour){
            // 퇴실시각+청소시각 = 입실시각이면 입실처리됨
            for(int i = startTime_Min ; i < endTime_Min ; i++ ){
                roomTimeTable[startTime_Hour][i] += 1;
            }
        }
        //Case2. 다른시간 퇴실
        //ex -> 1500, 1501... 1559, 1601...~1620
        // startHour != endHour
        //ㄴ> 시간차이만큼 반복,반복구가 endTime이 되면 분에서 탈출
        else if(startTime_Hour != endTime_Hour){
            for(int i = startTime_Hour ; i <= endTime_Hour ; i++){
                //Case2.1 퇴실시각 '시'가 되면
                if(i == endTime_Hour){
                    // 퇴실시각+청소시각 = 입실시각이면 입실처리됨
                    for(int lastTime_Min = 0 ; lastTime_Min < endTime_Min; lastTime_Min++){
                        roomTimeTable[i][lastTime_Min] += 1;
                    }
                }

                //Case2.2 입실시각 계산할때
                else if(i == startTime_Hour){
                    for(int firstTime_Min = startTime_Min ; firstTime_Min < 60 ; firstTime_Min++){
                        roomTimeTable[i][firstTime_Min] += 1;
                    }
                }
                //Case2.3 그 이외 00~59 까지 예약
                else{
                    for(int j = 0 ; j<60 ; j++){
                        roomTimeTable[i][j] += 1;
                    }
                }
            }
        }
        //반례 에러케이스
        else{
            System.out.println("[ErrCase] StartHour : " + startTime_Hour);
            System.out.println("[ErrCase] StartMin : "  + startTime_Min );
            System.out.println("[ErrCase] EndHour : "   + endTime_Hour  );
            System.out.println("[ErrCase] EndMin : "    + endTime_Min   );
        }
        return 0;
    }

    /**
     * @ itime[0] : 시작시간
     *   itime[2] : 종료시간
     */
    public int[] timeStringToInt(String arr[]){
        int[] iTime = new int[2];
        String[] delColon = new String[2];

        delColon[0] = arr[0].replace(":", "");
        delColon[1] = arr[1].replace(":", "");
        // System.out.println(delColon[0] + delColon[1] );
        try {
            iTime[0] = Integer.parseInt(delColon[0]);
            iTime[1] = Integer.parseInt(delColon[1]);
            
        } catch (Exception e) {
            // 예외처리
            e.printStackTrace();
        }
        return iTime;
    }
    
}
