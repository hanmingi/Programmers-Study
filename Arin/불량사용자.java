import java.util.*;

class Solution {
    String[] user_global;
    String[] ban_global;
    HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        user_global = user_id;
        ban_global = banned_id;

        dfs(new HashSet<>(), 0);
        return result.size();
    }

    void dfs(HashSet<String> set, int depth) {
        System.out.print(" || depth:" + depth);
        if (depth == ban_global.length) { // 모든 불량아이디가 채워지면 result에 담는다.
            result.add(set);
            return;
        }
        for (int i = 0; i < user_global.length; i++) {
            if (set.contains(user_global[i]))
                continue;
            if (isBanned(user_global[i], ban_global[depth])) { // 불량아이디이면
                set.add(user_global[i]); // 불량아이디 별로 조건에 만족하는 아이디를 HashSet에 넣어준다.user_global[i]
                System.out.print(" user_global[" + i + "]:" + user_global[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(user_global[i]);
            }
        }
    }

    // 불량아이디인지 여부를 리턴하는 함수
    boolean isBanned(String uId, String bId) {
        if (bId.length() != uId.length())
            return false; // 아이디 길이 다르면 불량아이디 아님.
        boolean boo = true;
        for (int i = 0; i < uId.length(); i++) {
            if (bId.charAt(i) != '*' && uId.charAt(i) != bId.charAt(i)) {
                boo = false;
                break;
            }
        }
        return boo;
    }
}