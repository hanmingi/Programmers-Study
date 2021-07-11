#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int answer = 0, n_len = 0;
    int s_len = strlen(s);
    char eng[10][6] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    int* number = (int*)malloc(sizeof(int) * s_len);

    for (int i = 0; i < s_len; i++) {
        if (isdigit(s[i])) {
            number[n_len] = s[i] - 48;
        }
        else {
            for (int j = 0; j < 10; j++) {
                if (memcmp(&s[i], &eng[j], strlen(eng[j])) == 0) {
                    number[n_len] = j;
                    i += strlen(eng[j]) - 1;
                    break;
                }
            }
        }
        n_len++;
    }

    for (int i = 0; i < n_len; i++) {
        answer += number[i] * pow(10, n_len - i - 1);
    }

    return answer;
}

// "one4seveneight" = 1478
// "23four5six7" = 234567
// "123" = 123
// 위처럼, 숫자 중 일부를 영어로 표현한 문자열을 숫자로 반환해주는 함수