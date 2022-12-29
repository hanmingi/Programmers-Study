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
    int i = 0;
    int word = 1;
    while (answer[i] != NULL) {
        if (answer[i] != 32) {
            if (answer[i] >= 'A' && answer[i] <= 'Z' && (word % 2) == 0) {
                answer[i] += 32;
            }
            else if (answer[i] >= 'a' && answer[i] <= 'z' && (word % 2) == 1) {
                answer[i] -= 32;
            }
            word++;
        }
        else
            word = 1;
        i++;
    }
    return answer;
}

// "try hello world" = "TrY HeLlO WoRlD"
// 위처럼 각 단어의 홀수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸어 출력함