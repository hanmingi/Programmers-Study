import java.util.*;

public class Main_42576 {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        int p = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (String part : participant) {
            if (hm.get(part) == null) {
                hm.put(part, 1);
            } else {
                p = hm.get(part) + 1;
                hm.put(part, p);
            }
        }
        for (String comp : completion) {
            p = hm.get(comp) - 1;
            hm.put(comp, p);
        }
        for (String key : hm.keySet()) {
            if (hm.get(key) == 1)
                answer = key;
        }
        return answer;
    }

}
