#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len = strlen(s);
    char* answer = (char*)malloc(sizeof(char) * len);
    strcpy(answer, s);
    for (int i = 0; i < len; i++) {
        int j = i + 1;
        while (j < len) {
            if (answer[i] < answer[j]) {
                int a = answer[i];
                answer[i] = answer[j];
                answer[j] = a;
            }
            j++;
        }
    }
    return answer;
}

// "Zbcdefg" = "gfedcbZ"
// 문자를 큰 것부터 작은 것 순으로 정렬한다.
// 대문자는 소문자보다 작은 것으로 간주된다. >> ASCII코드의 값과 동일함