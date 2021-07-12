#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(int x) {
    int a, b, c, d;
    int num = x;
    a = num / 1000;
    if(a != 0)
        num -= a * 1000;
    b = num / 100;
    if(b != 0)
        num -= b * 100;
    c = num / 10;
    if(c != 0)
        num -= c * 10;
    d = num;
    bool answer = true;
    if(x%(a+b+c+d)==0)
        return answer;
    else{
        answer = false;
        return answer;
    };
}
