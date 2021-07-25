#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int left, int right) {
    int answer = 0;
    while (left < right + 1) {
        int count = 2;
        if (left == 1)
            count = 1;
        for (int i = 2; i <= (left / 2); i++) {
            if (left % i == 0)
                count++;
        }
        if (count % 2 == 0)
            answer += left;
        else if (count % 2 == 1)
            answer -= left;
        left++;
    }
    return answer;
}

// "13, 17" = "43"
// "24, 27" = "52"
// 위처럼 왼쪽 인자와 오른쪽 인자까지의 수들의 약수가
// 짝수이면 더하고, 홀수이면 빼는 함수