import java.util.*;

class Solution {
	public static int solution(String[] words) {
		int answer = 0;
		int value = 0;
		ArrayList<String> al = new ArrayList<String>();

        //단어 리스트 입력 및 정렬
		for(String word : words)
			al.add(word);
		Collections.sort(al);

		value = len(al.get(0), al.get(1));
		if(value < al.get(0).length())
			answer += value + 1;
		else
			answer += value;

		for(int i = 1; i < words.length - 1; i++) {
			value = len(al.get(i), al.get(i-1));
            
            //짧은 단어가 긴 단어에 포함이되면 value 갱신
			value = Math.max(len(al.get(i), al.get(i+1)), value);

            //포함되지 않으면 +1해서 한단어를 더 입력
			if(value < al.get(i).length())
				answer += value + 1;
			else
				answer += value;
		}
		
		value = len(al.get(words.length - 2), al.get(words.length - 1));
		
		if(value < al.get(words.length-1).length())
			answer += value + 1;
		else
			answer += value;

		return answer;
	}

	public static int len(String s1, String s2) {
		int length = 0;
		for(int i = 0; i < s1.length() && i < s2.length(); i++) {
			if(s1.charAt(i) == s2.charAt(i))
				length++;
			else
				break;
		}

		return length;
	}

}