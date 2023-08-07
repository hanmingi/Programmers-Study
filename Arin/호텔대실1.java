import java.util.*;

class Solution_HotelBook {
    public int solution(String[][] book_time) {
        ArrayList<int[]> bookedList = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            // int stHHMM = Integer.parseInt(book_time[i][0].substring(0,2) +
            // book_time[i][0].substring(3,5));
            // int edHHMM = Integer.parseInt(book_time[i][1].substring(0,2) +
            // book_time[i][1].substring(3,5));
            int stHHMM = Integer.parseInt(book_time[i][0].replace(String.valueOf(":"), ""));
            int edHHMM = Integer.parseInt(book_time[i][1].replace(String.valueOf(":"), ""));
            int[] stedHHMM = { stHHMM, edHHMM };
            if (bookedList.size() == 0) {
                bookedList.add(stedHHMM);
                continue;
            }
            for (int j = 0; j < bookedList.size(); j++) {
                int st = 0;
                int ed = 0;
                if (bookedList.get(j)[0] % 100 <= 9 && bookedList.get(j)[0] % 100 >= 0) { // 시작시간
                    int hh = Integer.parseInt(book_time[i][0].substring(0, 2)) - 1;
                    int mm = 50 + bookedList.get(j)[0] % 100;
                    String s = hh + mm + "";
                    st = Integer.parseInt(s);
                } else {
                    st = bookedList.get(j)[0] - 10;
                }
                if (bookedList.get(j)[1] % 100 >= 50) { // 종료시간
                    int hh = Integer.parseInt(book_time[i][1].substring(0, 2)) + 1;
                    int mm = bookedList.get(j)[0] % 100;
                    String s = hh + mm + "";
                    ed = Integer.parseInt(s);
                } else {
                    ed = bookedList.get(j)[0] + 10;
                }

                if (edHHMM <= st) {
                    int[] stedHHMM2 = { stHHMM, bookedList.get(j)[1] };
                    bookedList.set(j, stedHHMM2);
                    break; // 없으면 메모리 초과
                } else if (stHHMM >= ed) {
                    int[] stedHHMM2 = { bookedList.get(j)[0], edHHMM };
                    bookedList.set(j, stedHHMM2);
                    break; // 없으면 메모리 초과
                }
                // if(edHHMM <= st || stHHMM >= ed){
                // bookedList.set(j, stedHHMM);
                // break; // 없으면 메모리 초과
                // }
                else {
                    bookedList.add(stedHHMM);
                    break;
                }
                // int startHour = Integer.parseInt(bookedList.get(j).substring(0,2));
                // int startMin = Integer.parseInt(bookedList.get(j).substring(3,5));
                // int endHour = Integer.parseInt(bookedList.get(j).substring(6,8));
                // int endMin = Integer.parseInt(bookedList.get(j).substring(9));
            }
        }
        // for(int j = 0; j < bookedList.size(); j++){
        // System.out.print(bookedList.get(j)[0]+"~"+bookedList.get(j)[1]+" \\ ");
        // }
        int answer = bookedList.size();
        return answer;
    }
}

public class 호텔대실1 {
    public static void main(String[] args) {
        Solution_HotelBook sol = new Solution_HotelBook();
        String[][] book_time = { { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" }, { "14:10", "19:20" },
                { "18:20", "21:20" } };
        sol.solution(book_time);
    }
}