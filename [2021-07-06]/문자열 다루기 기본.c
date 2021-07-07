#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
bool solution(const char* s) {
    bool answer = true;
    int len = strlen(s);
    if (len != 4 && len != 6)
        answer = false;
    for (int i = 0; i < len; i++) {
        if (!isdigit(s[i])) {
            answer = false;
            break;
        }
    }
    return answer;
}

// "a123" = false
// "1234" = true
// "12345" = false
// "123456" = true
// 배열의 길이가 4 또는 6이 아니면 false를 return
// 배열에 숫자 이외의 다른 것이 들어가면 false를 return