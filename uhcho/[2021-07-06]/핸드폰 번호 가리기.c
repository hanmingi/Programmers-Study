#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* phone_number) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len = strlen(phone_number);
    char* answer = (char*)malloc(sizeof(char) * len);
    for (int i = 0; i < len; i++) {
        if (i < len - 4)
            answer[i] = '*';
        else
            answer[i] = phone_number[i];
        answer[len] = NULL;
    }
    return answer;
}

// "01033334444" = "*******4444"
// "027778888" = "*****8888"
// 처럼 뒷 4자리를 제외한 나머지 숫자를 전부 *로 가린다.