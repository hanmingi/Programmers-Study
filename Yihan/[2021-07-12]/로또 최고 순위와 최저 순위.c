#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// lottos_len은 배열 lottos의 길이입니다.
// win_nums_len은 배열 win_nums의 길이입니다.
int* solution(int lottos[], size_t lottos_len, int win_nums[], size_t win_nums_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int) * 2);
    int count1 = 0;  //최고순위
    int count2 = 0;  //최저순위

    //당첨번호와 로또번호가 같으면 두 순위 모두 ++
    //로또번호가 0일 경우에는 최고순위만 ++
    for (int i = 0; i < lottos_len; i++) {
        for (int j = 0; j < lottos_len; j++) {
            if (lottos[i] != 0 && lottos[i] == win_nums[j]) {
                count1++;
                count2++;
            }
        }
        if (lottos[i] == 0)
            count1++;
    }
    answer[0] = 7 - count1;
    answer[1] = 7 - count2;
    //순위는 6등까지뿐이니, 6이상의 수는 6으로 고정
    for (int i = 0; i < 2; i++) {
        if (answer[i] > 6)
            answer[i] = 6;
    }

    return answer;
}

// [44,1,0,0,31,25] [31,10,45,1,6,19] = [3,5]
// [0,0,0,0,0,0] [38,19,20,40,15,25] = [1,6]
// [45,4,35,20,3,9] [20,9,3,45,4,35] = [1,1]
// 로또번호와 당첨번호를 비교하여 최고순위 최저순위를 알아내는 함수
// 0은 지워진 번호. 모르는 번호임.