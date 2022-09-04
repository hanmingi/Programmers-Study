import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution_BestAlbum { // 베스트앨범
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> songs = new HashMap<>(); // [key:장르, value:장르별총재생수] 를 담는 해시맵 생성

        // 장르별 총재생수 알아내기
        // int playsSum = 0;
        for (int i = 0; i < genres.length; i++) {
            // if ("".equals(songs.get(genres[i]))) { // 해시맵에 아직 들어오지 않은 장르(key)일 때에는 해당장르의
            // 재생수를 value로 넣음songs.get(genres[i]) == null
            // System.out.println("songs.get(genres[i])::::::::::: "+songs.get(genres[i]));
            // playsSum = plays[i];
            // } else { // 해시맵에 들어왔었던 장르(key)일 때에는 이미 있는 재생수(values)에 해당장르의 재생수를 더해줌
            // playsSum = songs.get(genres[i]) + plays[i];
            // }
            // songs.put(genres[i], playsSum);

            songs.put(genres[i], songs.getOrDefault(genres[i], 0) + plays[i]);
        }

        // (1)장르별 총재생수 많은 순으로, (2)각 노래의 재생수 순으로 두개씩 answer에 담기
        // 해시맵의 value를 기준으로 내림차순 정렬 (= 재생수 많은 순으로 해시맵 정렬)

        Integer[] playsOrder = new Integer[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            playsOrder = songs.values().toArray(new Integer[i]);
        }

        // for (int i = 0; i < playsOrder.length; i++) {
        // System.out.println("playsOrder["+i+"] : "+playsOrder[i]);
        // }
        Arrays.sort(playsOrder, Comparator.reverseOrder());

        String[] genresList = new String[playsOrder.length];

        // for (int i = 0; i < playsOrder.length; i++) {
        // System.out.println("after playsOrder["+i+"] : "+playsOrder[i]);
        // }
        for (String key : songs.keySet()) { // pop, classic, jazz
            Integer val = songs.get(key); // 1300,3600,2800
            for (int i = 0; i < playsOrder.length; i++) { // 3600 2800 1300
                if (val == playsOrder[i]) {
                    genresList[i] = key;
                }
            }
        } // genresList = pop, classic

        // for (int i = 0; i < genresList.length; i++) {
        // System.out.println("genresList: "+genresList[i]);
        // }

        // ArrayList<Integer> listt = new ArrayList<>();
        // for (int i = 0; i < genresList.length; i++) {
        // for (int k = 0; k < genresList.length; k++) {
        // if (genres[k].equals(genresList[i])) {
        // listt.add(plays[k]);
        // }
        // }
        // }
        // for (int i = 0; i < listt.size(); i++) {
        // System.out.println("listt: "+listt.get(i));
        // }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (String gen : genresList) { // genresList = classic, jazz, pop (정렬된거)
            ArrayList<Integer> an = new ArrayList<Integer>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(gen)) { // gen == genres[i]
                    an.add(plays[i]);
                    // System.out.println("plays::"+plays[i]);
                }
            }
            Collections.sort(an, Collections.reverseOrder());
            // for (int i = 0; i < an.size(); i++) {
            // System.out.print("an>>>>>"+ an.get(i)+" ");
            // }
            // System.out.println();

            // for (int i = 0; i < 2; i++) {
            for (int j = 0; j < plays.length; j++) {
                if (an.get(0) == plays[j] && !temp.contains(j) && gen.equals(genres[j])) {
                    // System.out.println("i: "+i+" / j: "+j);
                    // System.out.println("!temp.contains(j) :::: " + !temp.contains(j));
                    // System.out.println("genrePlay.get(plays[j]) ::::: "+ (gen == genrePlay.get(plays[j])));
                    // genrePlay.get(plays[j])) +"/"+gen+"/"+genrePlay.get(plays[j]));
                    // if (!temp.contains(j) && gen.equals(genres[j]) ) {//gen == genres[j]
                    temp.add(j);
                    // System.out.println(j+" 들어감!!");
                    break;
                    // }
                }

            }
            for (int j = 0; j < plays.length; j++) {
                if (an.size() >= 2 && an.get(1) == plays[j] && !temp.contains(j) && gen.equals(genres[j])) {
                    temp.add(j);
                    break;
                }
            }
            // }
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}

public class 베스트앨범 {
    public static void main(String[] args) {
        Solution_BestAlbum s = new Solution_BestAlbum();
        String[] genres = { "classic", "pop", "jazz", "jazz", "classic", "classic", "pop", "jazz" };
        int[] plays = { 500, 600, 1600, 600, 2500, 600, 700, 600 };
        int[] a = s.solution(genres, plays);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}