#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(int n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char* su = "수";
    char* bak = "박";
    char* answer = (char*)malloc(sizeof(char) * 3 * n);
    for (int i = 0; i < n; i++) {
        if (i % 2 == 0)
            strcpy(answer + i * 3, su);
        else
            strcpy(answer + i * 3, bak);
    }
    return answer;
}

// 3 = "수박수"
// 4 = "수박수박"
// 홀수일 때는 수, 짝수일 때는 박을 print하는 함수