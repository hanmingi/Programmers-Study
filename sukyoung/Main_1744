import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            if (k <= 0) {
                minus.add(k);
            }

            else {
                plus.add(k);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        for (int i = 0; i < plus.size(); i = i + 2) {
            if ((i + 1) < plus.size()) {
                if (plus.get(i) == 1 || plus.get(i + 1) == 1) {
                    answer += plus.get(i);
                    answer += plus.get(i + 1);
                    continue;
                } else {
                    answer += plus.get(i) * plus.get(i + 1);
                }
            } else {
                answer += plus.get(i);
            }
        }
        for (int i = 0; i < minus.size(); i = i + 2) {
            if (i + 1 < minus.size()) {
                answer += minus.get(i) * minus.get(i + 1);
            } else {
                answer += minus.get(i);
            }
        }
        System.out.println(answer);

    }
}
