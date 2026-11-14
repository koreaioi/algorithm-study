import java.util.*;

class Solution {
    
    // 100,000명이 있다.
    // 100,000명 중에서 (100,000-1) 번 특정인을 찾아야한다. 
    // 단순 반복문은 N * N이다.
    // N으로 해시에 넣고, O(1)의 속도로 찾는다.
    // 이러면 O(N) + O(1)이라 O(N)이 된다.
    // 동명이인이 있을 수 있다네요!!
    
    public static Map<String, Integer> participants = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        for(String p : participant){
            participants.put(p, participants.getOrDefault(p, 0)+1);
        }
        
        for(String c : completion){
            participants.put(c, participants.getOrDefault(c, 1)-1);
        }
        
        for(String p : participants.keySet()){
            if(participants.get(p) > 0){
                return p;
            }
        }
        
        String answer = "";
        return answer;
    }
    
//     // 또 다른 접근법: 정렬(Sorting) 활용
//     Arrays.sort(participant);
//     Arrays.sort(completion);
        
//     for (int i = 0; i < completion.length; i++) {
//         if (!participant[i].equals(completion[i])) {
//             return participant[i];
//         }
//     }
    // 장점 - 메모리를 덜 사용함. O(NLogN)
    // 단점 - 해시맵은 O(N)임
    
    
}