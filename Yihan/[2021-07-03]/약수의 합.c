#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int a = 1;
    while(a <= n){
        if(n % a == 0){
            answer += a;
            a++;
        }
        else
            a++;
    }
    return answer;
}
