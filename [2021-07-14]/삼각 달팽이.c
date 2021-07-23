#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)calloc(n * (n + 1) / 2, sizeof(int));
    int LastVal = n * (n + 1) / 2;
    int arr[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            arr[n][n] = 0;
        }
    }
    /*int w = 0, h = 0, num = 0;
    int max = n;
    int inner = 1;
    while (inner <= LastVal) {
        for(int i = 0; i < max; i++){
            arr[w][h] = inner;
            inner++;
            w++;
        }
        w--;
    }*/
    int k = 0, s = 1;
    while (s <= n) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j <= i; j++) {
                answer[k] = arr[i][j];
                k++;
            }
        }
        s++;
    }
    return answer;
}