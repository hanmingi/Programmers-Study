#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// a_len은 배열 a의 길이입니다.
// b_len은 배열 b의 길이입니다.
int solution(int a[], size_t a_len, int b[], size_t b_len) {
    int answer = 0;
    for (int i = 0; i < a_len; i++) {
        answer += (a[i] * b[i]);
    }
    return answer;
}

// [1,2,3,4] [-3,-1,0,2] = "3"
// [-1,0,1] [1,0,-1] = "-2"
// 두 배열의 내적을 구하는 함수