#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int* numbers = (int*)malloc(sizeof(int) * 50);
    int answer = 0;
    int len = strlen(s);
    int s_num = 0;
    int n_num = 0;
    while (s_num < len) {
        if (s[s_num] >= 48 && s[s_num] <= 57) {
            numbers[n_num] = s[s_num] - 48;
            s_num += 1;
        }
        else if (s[s_num] == 'z') {
            numbers[n_num] = 0;
            s_num += 4;
        }
        else if (s[s_num] == 'o') {
            numbers[n_num] = 1;
            s_num += 3;
        }
        else if (s[s_num] == 't') {
            if (s[s_num + 1] == 'w') {
                numbers[n_num] = 2;
                s_num += 3;
            }
            else {
                numbers[n_num] = 3;
                s_num += 5;
            }
        }
        else if (s[s_num] == 'f') {
            if (s[s_num + 1] == 'o') {
                numbers[n_num] = 4;
                s_num += 4;
            }
            else {
                numbers[n_num] = 5;
                s_num += 4;
            }
        }
        else if (s[s_num] == 's') {
            if (s[s_num + 1] == 'i') {
                numbers[n_num] = 6;
                s_num += 3;
            }
            else {
                numbers[n_num] = 7;
                s_num += 5;
            }
        }
        else if (s[s_num] == 'e') {
            numbers[n_num] = 8;
            s_num += 5;
        }
        else if (s[s_num] == 'n') {
            numbers[n_num] = 9;
            s_num += 4;
        }
        n_num++;
    }
    for (int i = 0; i < n_num; i++) {
        answer += numbers[i] * pow(10, n_num - i - 1);
    }
    return answer;
}

// "one4seveneight" = 1478
// "23four5six7" = 234567
// "123" = 123
// 위처럼, 숫자 중 일부를 영어로 표현한 문자열을 숫자로 반환해주는 함수