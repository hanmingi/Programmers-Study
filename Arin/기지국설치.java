class Solution_5G {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; // 추가로 설치할 기지국 수
        int offStart = 1; // 기지국 전파 도달 안되기 시작하는 아파트 번호
        int onStart = 0; // 기지국 전파 도달되기 시작하는 아파트 번호
        int offSection = 0; // 전파 미도달 구간
        for (int st : stations) { // 기지국 개수만큼
            onStart = st - w; // 전파 도달 시작 포인트 계산 = 현 기지국에서 도달거리(W) 뺌
            offSection = onStart - offStart; // 전파 미도달 구간은 (전파O시작포인트 - 전파X시작포인트)
            // 전파미도달구간을 "한 기지국으로 커버 가능한 거리"로 나누면 그 값은 설치할 기지국 수가 된다.
            // "한 기지국으로 커버 가능한 거리" = [도달거리*2(양쪽으로 전파 가니까)+1(기지국이 위치한 곳)]
            // 나눴는데 나머지 있으면(=커버 안 됨), 기지국 한 개 더 설치한다.
            answer += offSection % (w*2+1) > 0 ? offSection / (w*2+1) + 1 : offSection / (w*2+1);
            //answer += offSection % (w*2+1) == 0 ? offSection / (w*2+1) : offSection / (w*2+1) + 1;
            offStart = st + w + 1; // 다음 전파X시작포인트는 기지국+도달거리+1
        }
        if (stations[stations.length - 1] + w < n) { // 마지막 기지국이 마지막 아파트까지 커버못하면
            // 마지막 전파미도달구간(마지막기지국+도달거리를 아파트수에서 뺌)도 기지국 설치한다.
            offSection = n - (stations[stations.length - 1] + w); 
            //answer += offSection % (w*2+1) > 0 ? offSection / (w*2+1) + 1 : offSection / (w*2+1);
            answer += offSection % (w*2+1) == 0 ? offSection / (w*2+1) : offSection / (w*2+1) + 1;
        }
        return answer;
    }
}

public class 기지국설치 {
    public static void main(String[] args) {
        Solution_5G sol = new Solution_5G();
        int n = 600;
        int[] stations = { 1,600 };
        int w = 1;
        System.out.print(sol.solution(n, stations, w));
    }
}