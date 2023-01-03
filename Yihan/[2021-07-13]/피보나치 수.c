#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int* ans = (int*)malloc(sizeof(int) * 100000);
    for (int i = 0; i < n + 1; i++) {
        if (i < 2) {
            ans[i] = i;
        }
        else {
            ans[i] = ans[i - 2] + ans[i - 1];
            ans[i] %= 1234567;
        }
    }
    answer = ans[n];
    return answer;
}

// 피보나치 수를 1234567로 나눈 수
// 원래 배열을 안 쓰고 바로 실행했으나, 시간이 너무 오래 걸려서
// 배열에 값을 저장한 후, 출력하도록 바꾸었다