import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution_BestAlbum { // 베스트앨범
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> songs = new HashMap<>(); // [key:장르, value:장르별총재생수] 를 담는 해시맵 생성

        // 장르별 총재생수 알아내기
        int playsSum = 0;
        for (int i = 0; i < genres.length; i++) {
            if (songs.get(genres[i]) == null) { // 해시맵에 아직 들어오지 않은 장르(key)일 때에는 해당장르의 재생수를 value로 넣음
                playsSum = plays[i];
            } else { // 해시맵에 들어왔었던 장르(key)일 때에는 이미 있는 재생수(values)에 해당장르의 재생수를 더해줌
                playsSum = songs.get(genres[i]) + plays[i];
            }
            songs.put(genres[i], playsSum);
        }

        // (1)장르별 총재생수 많은 순으로, (2)각 노래의 재생수 순으로 두개씩 answer에 담기
        // 해시맵의 value를 기준으로 내림차순 정렬 (= 재생수 많은 순으로 해시맵 정렬)

        Integer[] playsOrder = new Integer[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            playsOrder = songs.values().toArray(new Integer[i]);
        }
        Arrays.sort(playsOrder, Comparator.reverseOrder());
        String[] genresList = new String[playsOrder.length];

        int j = 0;
        for (String key : songs.keySet()) {
            Integer val = songs.get(key);
            for (int i = 0; i < playsOrder.length; i++) {
                if (val == playsOrder[i]) {
                    genresList[j] = key;
                    j++;
                }
            }
        } // genresList = pop, classic

        for (int i = 0; i < genresList.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k < genresList.length; k++) {
                if (genres[k].equals(genresList[i])) {
                    list.add(plays[k]);
                }
            }
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (String gen : genresList) { // genresList = pop, classic (정렬된거)
            ArrayList<Integer> an = new ArrayList<Integer>();
            for (int i = 0; i < genres.length; i++) {
                if (gen == genres[i]) {
                    an.add(plays[i]);
                }
            }
            Collections.sort(an, Collections.reverseOrder());
            int idx = 0;
            for (int i = 0; i < an.size(); i++) {
                if (idx != 2) {
                    idx++;
                    for (int l = 0; l < plays.length; l++) {
                        if (plays[l] == an.get(i)) {
                            if (!temp.contains(l)) {
                                temp.add(l);
                                break;
                            }
                        }
                    }
                }
            }
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
        String[] genres = { "classic", "pop", "classic", "classic", "pop" }; // 10자리
        int[] plays = { 500, 600, 150, 800, 2500 };
        int[] a = s.solution(genres, plays);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}