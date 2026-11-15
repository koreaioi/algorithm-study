import java.util.*;

class Solution {
    //
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Truck> q = new ArrayDeque<>();
        int totalWeight = truck_weights[0];
        int time = 1;
        int index = 1;
        q.offer(new Truck(truck_weights[0], 1)); // 초기 트럭 큐에 넣어주기.
        
        // 기존 트럭을 앞으로 이동.
        // 이때, p > length이면 내리기
        
        // 다리에 추가할 수 있냐, 
        
        while(!q.isEmpty()){
            // 기존 트럭 앞으로 이동.
            for(Truck t : q){
                t.move();
            }
            
            // 맨 앞의 트럭이 다리를 나갔으면 q에서 빼주기 + 무게 빼주기.
            if(q.peek().p > bridge_length){
                totalWeight -= q.peek().w;
                q.poll();
            }
            
            // 인덱스 방어로직
            if(index >= truck_weights.length){
                time++;
                continue;
            }
            
            // 기존 + 새로운 트럭 무게가 상한보다 낮으면 큐에 넣기.
            int nextWeight = truck_weights[index];
            if(totalWeight + nextWeight <= weight){
                totalWeight += nextWeight;
                index++;
                q.offer(new Truck(nextWeight, 1));
            }
        
            time++;
        }
        
        // int answer = 0;
        return time;
    }
    
    static class Truck{
        int w; // 무게
        int p; // 다리에서 위치. 1부터 시작.
        public Truck(int w, int p){
            this.w = w;
            this.p = p;
        }
        public void move(){
            p++;
        }
    }
    
}