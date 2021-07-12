#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int solution(int n) {
    int answer = 0;
    int count = 0;
    int m = n;
    while (m != 0) {
        m /= 3;
        count++;
    }//3진수의 자릿수
    int* arr = (int*)malloc(sizeof(int) * count);
    for (int i = 0; i < count; i++) {
        int j = n % 3;
        arr[i] = j;
        n /= 3;
    }
    for (int k = 0; k < count; k++) {
        answer += arr[k] * pow(3, count - k - 1);
    }
    return answer;
}

// solution(45) = 7
// solution(125) = 229
// 자연수 n을 입력한 후, 3진수로 변환한다
// 3진수상에서 앞뒤를 뒤집은 후, 다시 10진수로 변환한다
// 그것보다 효율적인 알고리즘을 찾아서, 처음부터 앞뒤반전된 3진수를 arr에 저장하고, 10진수로 바로 변환함.