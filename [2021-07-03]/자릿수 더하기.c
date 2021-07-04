#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int num = 0;
    while(n != 0){
        num = n % 10;
        n /= 10;
        answer += num;
    }
    return answer;
}
