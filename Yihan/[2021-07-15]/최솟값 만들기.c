#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int static upper(const void* first, const void* second) {
    if (*(int*)first > * (int*)second)
        return 1;
    else if (*(int*)first < *(int*)second)
        return -1;
    else
        return 0;
}

int static lower(const void* first, const void* second) {
    if (*(int*)first > * (int*)second)
        return -1;
    else if (*(int*)first < *(int*)second)
        return 1;
    else
        return 0;
}

// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.
int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;
    // A 내림차순으로 정렬
    qsort(A, A_len, sizeof(int), upper);
    //B 오름차순으로 정렬
    qsort(B, B_len, sizeof(int), lower);

    for (int i = 0; i < A_len; i++) {
        answer += A[i] * B[i];
    }
    return answer;
}

// [1,4,2] [5,4,4] = 29
// [1,2] [3,4] = 10
// 위처럼 각 하나의 숫자를 뽑아 곱한 값을 더한 것의 최솟값을 return
// stdlib에 포함된 qsort()라는 함수를 이용하여, 정렬의 시간을 줄임으로서 해결