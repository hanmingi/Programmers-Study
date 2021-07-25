#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// prices_len은 배열 prices의 길이입니다.
int* solution(int prices[], size_t prices_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * prices_len);
    int k = 0;
    for (int i = 0; i < prices_len - 1; i++) {
        int count = 0;
        for (int j = i + 1; j < prices_len; j++) {
            if (prices[i] <= prices[j]) {
                count++;
            }
            else {
                count++;
                break;
            }
        }
        answer[i] = count;
        answer[prices_len - 1] = 0;
    }
    return answer;
}

// [1,2,3,2,3] = [4,3,1,1,0]
// [1,2,3,2,3,1] = [5,4,1,2,1,0]
// 위처럼 주식 가격이 떨어지지 않은 기간이 몇 초인지 return
// 1초 뒤에 가격이 떨어지더라도, 1초간 가격이 떨어지지 않은 것으로 본다.