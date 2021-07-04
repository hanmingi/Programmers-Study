#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int a, int b) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char* answer = (char*)malloc(sizeof(char)*3);
    int d = 0;
    for(int i = 1; i < a ; i++){ //전월까지의 일 수 계산
        if(i == 2)
            d += 29;
        else if(i % 2 == 0 && i < 8)
            d += 30;
        else if(i % 2 == 1 && i < 8)
            d += 31;
        else if(i % 2 == 1 && i >= 8)
            d += 30;
        else if(i % 2 == 0 && i >= 8)
            d += 31;
    }
    d += b;
    if(d % 7 == 1)
        answer = "FRI";
    else if(d % 7 == 2)
        answer = "SAT";
    else if(d % 7 == 3)
        answer = "SUN";
    else if(d % 7 == 4)
        answer = "MON";
    else if(d % 7 == 5)
        answer = "TUE";
    else if(d % 7 == 6)
        answer = "WED";
    else
        answer = "THU";
    return answer;
}
// solution(5, 24) = "TUE"
// solution(1, 1) = "FRI"
//이런식으로 날짜 입력 시 그 날의 요일이 출력