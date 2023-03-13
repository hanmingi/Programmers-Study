class Solution {
    public int solution(String name) {
        int temp; 
        int count=0;
        int len = name.length();
        char[] namech = name.toCharArray();

        for(int i=0; i<len; i++) {
            temp = namech[i]-65;
            if(temp<13){    //알파벳26 중간 뒤부터는 뒤에서가더빠름
                count = count + temp;
            }else{
                count = count + 26 - temp;
            }

        }

        int total=len-1; //처음부터 끝까지 쭉간다면
        for(int i=0; i<len; i++) {
            int move = i+1; //다음이동번째
            while(move < len && namech[move] == 'A') {
                move++;    //연속된 a개수
            }    
            total = Math.min(total, i+len-move+Math.min(i, len-move)); //뒤를먼저갔다가는게 짧은지먼저 판단후 그다음 전체길이가 total보다 짧으면 뒤로가는것까지도 비교
        }
        count = count + total;
        return count;
    }
}
