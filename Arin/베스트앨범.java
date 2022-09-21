import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution_BestAlbum { // 베스트앨범
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총재생수 알아내기
        HashMap<String, Integer> songs = new HashMap<>(); // [key:장르, value:장르별총재생수] 를 담는 해시맵 생성
        for (int i = 0; i < genres.length; i++) {
            songs.put(genres[i], songs.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 총재생수 내림차순 정렬
        Integer[] playsOrder = new Integer[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            playsOrder = songs.values().toArray(new Integer[i]);
        }
        Arrays.sort(playsOrder, Comparator.reverseOrder());

        // 총재생수 내림차순으로 장르명 정렬
        String[] genresList = new String[playsOrder.length];
        for (String key : songs.keySet()) {
            Integer val = songs.get(key);
            for (int i = 0; i < playsOrder.length; i++) {
                if (val == playsOrder[i]) {
                    genresList[i] = key;
                }
            }
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (String gen : genresList) { // 총재생수 내림차순으로 정렬된 장르명
            ArrayList<Integer> p = new ArrayList<Integer>();
            for (int i = 0; i < genres.length; i++) { // 처음 주어진 장르명 배열 돌며
                if (genres[i].equals(gen)) { // 내림차순 정렬된 장르명과 일치하면
                    p.add(plays[i]); // 처음 주어진 재생수 배열의 해당 인덱스 재생수를 p에 담는다
                }
            }
            Collections.sort(p, Collections.reverseOrder()); // p 내림차순 정렬
            if (p.size() <= 1) {
                for (int j = 0; j < plays.length; j++) {
                    // p의 첫번째수(가장많은재생수)가 처음 주어진 재생수 배열에 있고,
                    // 해당 인덱스가 아직 temp에 없으며, 처음 주어진 장르명 배열의 장르명과 일치할 것
                    if (p.get(0) == plays[j] && !temp.contains(j) && gen.equals(genres[j])) {
                        temp.add(j);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < plays.length; j++) {
                    if (p.get(1) == plays[j] && !temp.contains(j) && gen.equals(genres[j])) {
                        temp.add(j);
                        break;
                    }
                }
            }

        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++)
            answer[i] = temp.get(i);
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