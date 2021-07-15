#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.
int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;
    // A 내림차순으로 정렬
    for (int i = 0; i < A_len; i++) {
        for (int j = i + 1; j < A_len; j++) {
            if (A[i] < A[j]) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
    }
    //B 오름차순으로 정렬
    for (int i = 0; i < B_len; i++) {
        for (int j = i + 1; j < B_len; j++) {
            if (B[i] > B[j]) {
                int temp = B[i];
                B[i] = B[j];
                B[j] = temp;
            }
        }
    }
    for (int i = 0; i < A_len; i++) {
        answer += A[i] * B[i];
    }
    return answer;
}

// [1,4,2] [5,4,4] = 29
// [1,2] [3,4] = 10
// 위처럼 각 하나의 숫자를 뽑아 곱한 값을 더한 것의 최솟값을 return
// A는 오름차순, B는 내림차순으로 정렬한 후, 순서대로 원소를 곱해서 풀었으나,
// 실행 결과는 통과하나, 효율성 테스트에서 시간초과가 나옴
// 정렬 과정에서 2중for문을 사용하여 O(n^2)의 시간복잡도를 가진 것이 원인이라고 생각됨