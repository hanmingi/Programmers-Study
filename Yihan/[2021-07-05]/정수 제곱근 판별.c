#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

long long solution(long long n) {
    long long answer = 0;
    for (int i = 0; i <= sqrt(n); i++) {
        answer = i;
    }
    if (answer == sqrt(n))
        answer = pow((answer + 1), 2);
    else
        answer = -1;
    return answer;
}

//solution(121) = 144
//solution(3) = -1
//위처럼 입력한 수의 제곱근이 정수이면 제곱근+1의 제곱을,
//제곱근이 정수가 아니면 -1을 return