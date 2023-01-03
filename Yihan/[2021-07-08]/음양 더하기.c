#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// absolutes_len은 배열 absolutes의 길이입니다.
// signs_len은 배열 signs의 길이입니다.
int solution(int absolutes[], size_t absolutes_len, bool signs[], size_t signs_len) {
    int answer = 0;
    for (int i = 0; i < absolutes_len; i++) {
        if (signs[i] == 0)
            absolutes[i] *= (-1);
        answer += absolutes[i];
    }
    return answer;
}

// [4, 7, 12] [true, false, true] = 9
// 첫 배열은 수의 절대값, 두번째 배열은 true면 양수, false면 음수를 표현
// answer에 실제 정수들의 값의 합을 구한다