class Solution_d {
    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        int p = 0;
        String temp = "";
        int[] arr = new int[3];

        for(int i=0;i<dartResult.length();i++){
            char a=dartResult.charAt(i);
            if(a=='*'){
                arr[index-1]*=2;
                if(index-2>=0){
                    arr[index-2]*=2;
                }
            }
            else if(a=='#'){
                arr[index-1] *= -1;
            }
            else if(a=='S'){
                p=Integer.parseInt(temp);       
                arr[index]=(int)Math.pow(p,1);  
                index++;
                temp="";
            }
            else if(a=='D'){
                p=Integer.parseInt(temp);
                arr[index]=(int)Math.pow(p,2); 
                index++;
                temp="";
            }
            else if(a=='T'){
                p=Integer.parseInt(temp);
                arr[index]=(int)Math.pow(p,3); 
                index++;
                temp="";
            }
            else{
                temp+=String.valueOf(a); //10인경우가 있어서 += 해주어야함
            }
        }
        answer=arr[0]+arr[1]+arr[2];

        return answer;
    }
}

public class Main__17682 {
    public static void main(String[] args) {

        Solution_d s = new Solution_d();

        System.out.println(s.solution("1S2D*3T")); //37
        
    }
}