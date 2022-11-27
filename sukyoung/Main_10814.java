import java.util.*;
public class Main_10814 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String arr[][]  = new String[N][3]; 
		for(int i=0;i<N;i++){			//먼저 나이랑 이름을 입력 받는다
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}
		for(int j=0;j<N;j++){
			arr[j][2]=Integer.toString(j);		//들어온순서대로 번호매기기, 또한 위에서 배열을 string으로 했기때문에 int를 string으로
		}
		
		
		Arrays.sort(arr,(a,b)-> {
			if(a[0] == b[0]) {
				return a[2].compareTo(b[2]);		//나이가 같으면 들어온순서대로를 비교해준다
			}else {
				return Integer.parseInt(a[0])-Integer.parseInt(b[0]);		//나이를 비교
			}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);		//쮸르르륵 나열해준다
		}
	}
}