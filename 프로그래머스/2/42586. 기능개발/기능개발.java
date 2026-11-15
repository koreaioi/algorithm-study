import java.util.*;

class Solution {
    
    // 우선 각 작업이 끝나는데 며칠이 걸리는 지 계산해두기
    // 
    // 7, 3, 9 임. 이를 큐에 넣음.
    // 큐에서 하나 꺼내놓고 시작.
    // 7(max)를 기준으로 다음 값이 7보다 작으면 
    // count++ 7보다 크면 count를 answer에 넣고 max를 큰수로 바꿈.
    
    // 5, 10, 1, 1, 20 ,1
    // 
    
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> al = new ArrayList<>();
        
        int max = (100 - progresses[0] + speeds[0] -1) / speeds[0];
        int count = 1;
        for(int i = 1 ; i < progresses.length ; i++){
            int target = (100 - progresses[i] + speeds[i] -1) / speeds[i];
            if(max >= target){
                count++;
            }else{
                al.add(count);
                count=1;
                max = target;
            }
            
            // System.out.println(done);
            // q.offer(done);
        }
        
        // int max = q.poll();
        // int count = 1;
        // int L = q.size();
        // for(int i =  0; i < L; i++){
        //     int target = q.poll();
        //     if(max >= target){
        //         count++;
        //     } else {
        //         al.add(count);
        //         count = 1;
        //         max = target;
        //     }
        // }
        al.add(count);
        
        int[] answer = al.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        // int[] answer = {};
        return answer;
    }
}