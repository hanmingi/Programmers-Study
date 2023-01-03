#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// numbers_len은 배열 numbers의 길이입니다.
int* solution(int numbers[], size_t numbers_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * numbers_len * (numbers_len - 1) / 2);
    int answers_len = 0;
    int count = 0;
    for (int i = 0; i < numbers_len; i++) {
        for (int j = i + 1; j < numbers_len; j++) {
            int semiAns = numbers[i] + numbers[j];
            for (int k = 0; k < answers_len; k++) {
                if (answer[k] == semiAns)
                    count++;
            }
            if (count == 0) {
                answer[answers_len] = semiAns;
                answers_len++;
            }
            count = 0;
        }
    }
    for (int i = 0; i < answers_len; i++) {
        for (int j = i + 1; j < answers_len; j++) {
            if (answer[i] > answer[j]) {
                int temp = answer[i];
                answer[i] = answer[j];
                answer[j] = temp;
            }
        }
    }
    return answer;
}

// [2,1,3,4,1] = [2,3,4,5,6,7]
// [5,0,2,7] = [2,5,7,9,12]
// 위처럼, 2가지 수를 더해서 나올 수 있는 모든 경우의 수를 출력
// 중복된 값은 취급하지 않고, 오름차순으로 정렬해야한다.