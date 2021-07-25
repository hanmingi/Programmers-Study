#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int a, int b) {
    long long answer = 0;
    int temp;
    if (a > b) {
        for (int i = b; i <= a; i--) {
            answer += i;
        }
    }
    else
        for (int i = a; i <= b; i++) {
            answer += i;
        }
    return answer;
}

// solution(3, 5) = 12
// solution(3, 3) = 3
// solution(5, 3) = 12
// 수의 대소관계는 정해져 있지 않음