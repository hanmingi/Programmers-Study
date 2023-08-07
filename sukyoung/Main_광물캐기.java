import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        int count = picks[0] + picks[1] + picks[2];
        
        //5개씩끊어서 어차피 한번쓴거 5번연속써야함
        for(int i=0;i<minerals.length;i+=5) {
            
             //이거때문에 시간이 엄청오래걸림
             // 생각을해보자 곡갱이로 다캤는데 mineral이 더많으면 캘수는 없음
             // 그런데 곡갱이개수를 카운트안하면 list에 add하는것에 안캐는 mineral이 들어갈수 있따.따봉
             if(count <= 0) break;

            int[] p = new int[3];
            int j = i;
            while(j<minerals.length &&j < i+5) {
                if(minerals[j].equals("diamond")) {
                    p[0] += 1;
                    p[1] += 5;
                    p[2] += 25;
                }

                if(minerals[j].equals("iron")) {
                    p[0] += 1;
                    p[1] += 1;
                    p[2] += 5;
                }

                if(minerals[j].equals("stone")) {
                    p[0] += 1;
                    p[1] += 1;
                    p[2] += 1;
                }
                j++;
            }

            list.add(p);
            count--;
        }
        //어차피 돌곡갱이로 캐서 젤로 시간큰거는 무조건 다이아곡갱이로캐야 이득
        //근데 돌곡갱이시간크면 그다음은 철로 캐서 젤 시간큰 것으로
        Collections.sort(list,new Comparator<int[]> (){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[2] != b[2]) return b[2] - a[2];
                if(a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            }
        });
        // 다이아/철/ 돌 곡괭이 순서로 계산
        for(int[] a : list) {
            if(picks[0] > 0) {
                answer += a[0];
                picks[0]--;
                continue;
            }

            if(picks[1] > 0) {
                answer += a[1];
                picks[1]--;
                continue;
            }

            if(picks[2] > 0) {
                answer += a[2];
                picks[2]--;
                continue;
            }
        }

        return answer;
    }
}
