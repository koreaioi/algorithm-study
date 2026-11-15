import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        Deque<Job> waitQ = new ArrayDeque<>();
        Deque<Job> executedQ = new ArrayDeque<>();
        
        for(int i = 0 ; i < priorities.length ; i++){
            waitQ.offer(new Job(i, priorities[i]));
        }
        
        int answer = 1;
        while(!waitQ.isEmpty()){
            Job job = waitQ.poll();
            
            if(!hasMax(waitQ, job.p)){ // 큰 값이 존재하지 않으면
                if(job.location == location){
                    return answer;
                }else{
                    answer++;
                }
                // executedQ.offer(job);
                continue;
            }
            
            waitQ.offer(job);
        }
        
        // int answer = 0;
        return answer;
    }
    
    public static boolean hasMax(Deque<Job> waitQ, int prior){
        return waitQ.stream()
            .anyMatch(j -> j.p  > prior);
    }
    
    static class Job{
        int location; // 원래 위치.
        int p; // 우선순위.
        public Job(int location, int p){
            this.location =location;
            this.p = p;
        }
    }
    
    
    
}