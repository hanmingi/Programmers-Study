#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// numbers_len은 배열 numbers의 길이입니다.
char* solution(int numbers[], size_t numbers_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(1);
    int** nums = (int**)malloc(sizeof(int*) * numbers_len);
    int* copy = (int*)malloc(sizeof(int) * numbers_len);
    strcpy(copy, numbers);
    // numbers_len행 4열짜리 2차원 배열 동적할당
    for (int i = 0; i < numbers_len; i++) {
        nums[i] = (int*)malloc(sizeof(int) * 4);
    }
    // 1열의 수(처음 나오는 수)를 비교하기 위해 copy의 모든 수를 1000 이상이 되도록 곱셈
    for (int i = 0; i < numbers_len; i++) {
        if (copy[i] == 0)
            continue;
        else {
            while (copy[i] > 999) {
                copy[i] *= 10;
            }
        }

    }
    //배열에 수 채워넣기
    for (int i = 0; i < numbers_len; i++) {
        for (int j = 0; j < 4; j++) {
            nums[i][3 - j] = copy[i] % 10;
            copy[i] /= 10;
        }
    }


    return answer;
}
/*
[6,10,2] = 6210
[3,30,34,5,9] = 9534330
아래와같이 배열을 짜고, 각 행의 첫번째 열을 비교하려 했으나,
3, 30과 같이 배열에서 구분할 수 없는 수의 경우를 처리할 방법을 생각하지 못해 보류함

  i = numbers[i]
j 3 3 3 5 9
  0 0 4 0 0
  0 0 0 0 0
  0 0 0 0 0 */