#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)calloc(n * (n + 1) / 2, sizeof(int));
    int LastVal = n * (n + 1) / 2;
    int Val = 1;
    int arr[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            arr[n][n] = 0;
        }
    }
    int max = n, w = 0, h = 0;
    while (1) {
        for (int i = 0; i < max; i++) {
            arr[w++][h] = Val++;
        }
        w--;
        h++;
        max--;
        if (max == 0)
            break;
        for (int i = 0; i < max; i++) {
            arr[w][h++] = Val++;
        }
        h -= 2;
        w--;
        max--;
        if (max == 0)
            break;
        for (int i = 0; i < max; i++) {
            arr[w--][h--] = Val++;
        }
        w += 2;
        h++;
        max--;
        if (max == 0)
            break;
    }

    int k = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            answer[k] = arr[i][j];
            k++;
        }
    }
    return answer;
}

// 삼각형의 꼭지점부터 반시계방향으로 달팽이 채우기 후,
// 그것을 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 출력
// 4 = [1,2,9,3,10,8,4,5,6,7]