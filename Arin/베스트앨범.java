import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution_BestAlbum { // 베스트앨범
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> songs = new HashMap<>(); // [key:장르, value:장르별총재생수] 를 담는 해시맵 생성

        // 장르별 재생수 알아내기
        int playsSum = 0;
        for (int i = 0; i < genres.length; i++) {
            if (songs.get(genres[i]) == null) { // 해시맵에 아직 들어오지 않은 장르(key)일 때에는 해당장르의 재생수를 value로 넣음
                playsSum = plays[i];
            } else { // 해시맵에 들어왔었던 장르(key)일 때에는 이미 있는 재생수(values)에 해당장르의 재생수를 더해줌
                playsSum = songs.get(genres[i]) + plays[i];
            }
            songs.put(genres[i], playsSum);
        }

        // // 해시맵에 장르별 총재생수 잘 들어갔는지 확인
        // Set<String> songsSet = songs.keySet(); //key만으로 이루어진 세트 만듦
        // for (String keyy : songsSet) {
        // System.out.println(keyy + " : " + songs.get(keyy));
        // }

        // (1)장르별 총재생수 많은 순으로, (2)각 노래의 재생수 순으로 두개씩 answer에 담기
        // 해시맵의 value를 기준으로 내림차순 정렬 (= 재생수 많은 순으로 해시맵 정렬)
        // int[] playsOrderr = new int[songs.size()];
        // Set<String> songsKeySet = songs.keySet();
        // Iterator songsKeyIter = songsKeySet.iterator();
        // int j = 0;
        // while(songsKeyIter.hasNext()){
        // playsOrderr[j] = songs.get(songsKeyIter.next());
        // j++;
        // }
        Integer[] playsOrder = new Integer[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            playsOrder = songs.values().toArray(new Integer[i]);
        }
        Arrays.sort(playsOrder, Comparator.reverseOrder());
        for (int i = 0; i < songs.size(); i++) {
        System.out.println(playsOrder[i]);
        }
        Set<String> songsSet = songs.keySet(); //key만으로 이루어진 세트 만듦
        String[] genresList = new String[playsOrder.length];

        int j = 0;
        for(String key:songs.keySet()){
            Integer val = songs.get(key);
            System.out.println("key: "+key);
            for (int i = 0; i < playsOrder.length; i++) {
                if(val==playsOrder[i]){
                    genresList[j]=key;
                    j++;
                }
            }
        }//genresList = pop, classic

        Integer[] playsArr = Arrays.stream(plays).boxed().toArray(Integer[]::new);
        Arrays.sort(playsArr, Comparator.reverseOrder());

        HashMap<Integer, Integer> indexAndPlays=new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            indexAndPlays.put(plays[i], i);
        }

        for (int i = 0; i < genresList.length; i++) {
            System.out.println(genresList[i]);
            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k < genresList.length; k++) {
                if(genres[k].equals(genresList[i])){
                    list.add(plays[k]);
                }
            }

            //for (int k = 0; k < 2; k++) {
                int index1 = Arrays.asList(genres).indexOf(genresList[i]);
                System.out.println(indexAndPlays.get(plays[index1]));
                // answer[i]=indexAndPlays.get(plays[index1]);
            //}
        }


        return answer;
    }
}

public class 베스트앨범 {
    public static void main(String[] args) {
        Solution_BestAlbum s = new Solution_BestAlbum();
        String[] genres = { "classic", "pop", "classic", "classic", "pop" }; // 10자리
        int[] plays = { 500, 600, 150, 800, 2500 };
        System.out.println(s.solution(genres, plays));
    }

}