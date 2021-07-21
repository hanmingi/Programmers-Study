#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)calloc(n * (n + 1) / 2, sizeof(int));
    int** arr = (int**)malloc(sizeof(int*) * n);
    for (int i = 0; i < n; i++) {
        arr[i] = (int*)malloc(sizeof(int) * (i + 1));
    }
    int w = 0, h = 0, num = 0;
    int max = n;
    int inner = 1;
    while (inner < (n * (n + 1) / 2) + 1) {
        for (int i = 0; i < max; i++) {
            arr[w++][h] = inner;
            inner++;
        }
        max++;
        for (int i = 0; i < max; i++) {
            arr[w][++h] = inner;
            inner++;
        }
        max--;
        for (int i = 0; i < max; i++) {
            arr[--w][--h] = inner;
            inner++;
        }
        max--;
    }
    int k = 0, s = 1;
    while (s < n + 1) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                answer[k] = arr[i][j];
                k++;
            }
        }
        s++;
    }
    return answer;
}

// 4 입력시 크기가 4인 삼각형의 맨 위 꼭지점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
// 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return
// 4 = [1,2,9,3,10,8,4,5,6,7]
// 2차원 배열을 동적할당하여 직각삼각형 모양을 만들고, for문으로 첫 행을 채우고,
// while문 내에서 밑 줄 열, 그 후 대각선을 채우는 식으로 프로그래밍 함.
// while문 내에서 if문으로 max값이 0가 되면 break하여 while문을 빠져나오도록 설계