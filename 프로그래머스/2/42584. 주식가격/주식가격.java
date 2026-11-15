import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int p : prices){
            q.offer(p);
        }
        
        int L = q.size();
        for(int i = 0 ; i < L - 1 ; i++){
            int value = q.poll();
            int count = 0;
            
            for(int target : q){
                if(target >= value ){
                    // 아무것도 안함.
                }else{ // target < value
                    count++;
                    break;
                }
                count++;
            }
            
            answer.add(count);
        }
        answer.add(0);
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}