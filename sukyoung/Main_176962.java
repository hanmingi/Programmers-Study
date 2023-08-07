package sukyoung;

import java.util.*; //(스택에서)pop은 제거,peek젤위상단값
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String[]> working=new Stack<>();      //스택은 FILO 스택쓴이유는 과제가 대기텀에 들어가는것들중에서 마지막으로 멈춘것을 먼저 빼서 하니까 스택이랑 구조가같음
        Queue<String[]> wait=new LinkedList<>();    //맨처음에 정렬해주고 바로 앞에 시간있는것 부터 차례대로 빼주려고 큐는 FIFO이니까 
        int index=0;

        Arrays.sort(plans,(a,b)->{
            if(a[1].split(":")[0].equals(b[1].split(":")[0]))
                return Integer.parseInt(a[1].split(":")[1])-Integer.parseInt(b[1].split(":")[1]);  //먼저 SPLIT으로 앞에 시간을 비교 근데 만약 시간같으면 뒤에 분으로 

            else 
                return Integer.parseInt(a[1].split(":")[0])-Integer.parseInt(b[1].split(":")[0]); //시간으로 쪼개서 비교 
        });

        for(String[] s:plans)
            wait.add(s);   //정렬된 순서대로 일다ㄴ 다 넣기

        while(!wait.isEmpty()){
            working.push(wait.poll());                            //wait에 있는거 poll써서 값 반환해주고 없애기
            if(wait.isEmpty()){                                   //wait가 빈다는것은 마지막꺼 poll해서 working에 넣었기때문
                while(!working.isEmpty()){
                    answer[index]=working.pop()[0];
                    index++;                                      //처음에 다 넣었던  wait에 있는 것들이 비게되고 working 에 남은것들 싹다 정답에넣기 
                                                                  //그이유는 이때 남은 working은 짤짤이 남은것들 잠시 멈춰둔 과제들만 남아있기 때문
                }
                break;
            }
            int term=Termcount(wait.peek()[1],working.peek()[1]);       //텀은 앞에시간과 뒤에 시간 차이 그래야 그 사이시간에 할수 있냐없냐 판단하니
            while(!working.isEmpty()){
                if(term>=Integer.parseInt(working.peek()[2])){          //과제마치는 시간이 텀보다 작으면 바로 과제를 끝낼수 있다
                    answer[index]=working.peek()[0];                    //텀이 더 크니까 완료가능하니 바로 정답에 추가
                    term = term-Integer.parseInt(working.pop()[2]);     //텀에서 과제끝난시간을 빼고 그러면 그 남은시간에도 또 과제를 해야하니 텀갱신
                    index++;
                }
                else{                               //만약 텀이 과제마치는시간보다 작으면 
                    String[] work= working.pop();
                    work[2]=String.valueOf((Integer.parseInt(work[2])-term)); //아까위 if문에서 텀에서 과제끝난시간을빼고도 남은시간에서 최대한 텀뺀 시간을 뺀다 
                                                                              //그럼담에 pop했던 것의 시간을 바꿔줘야한다 설명에서(남은시간 몇분이것을 의미)
                    working.push(work);                                       //아직 다 못끝냈으니 이것은 working안에다가 다시 넣어준다.
                    break;
                }
            }
        }
        return answer;
    }
    public int Termcount(String wait, String working){
        int waittime=Integer.parseInt(wait.split(":")[0])*60+Integer.parseInt(wait.split(":")[1]);
        int worktime=Integer.parseInt(working.split(":")[0])*60+Integer.parseInt(working.split(":")[1]);
        return waittime-worktime;
    }
}
