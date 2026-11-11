import java.util.*;

class Solution {
    
    public static Map<String, Integer> hm1 = new HashMap<>(); // 순서찾기
    public static Map<Integer, String> hm2 = new HashMap<>(); // 이름찾기
    
    public List<String> solution(String[] players, String[] callings) {
        
        for(int i = 0 ; i < players.length ; i++){
            hm1.put(players[i], i);
            hm2.put(i, players[i]);
        }
        
        for(String call : callings){
            swap(call);
        }
     
        
        // return Arrays.toString(hm2.values());
        return hm2.values().stream().toList();
    }
    
    public void swap(String name){
        int order = hm1.get(name); // 바꿀 놈 순서 찾기
        String target = hm2.get(order-1); // 따잇 이름찾기.
        
        hm1.put(name, order-1);
        hm2.put(order, target);
        
        hm1.put(target, order);
        hm2.put(order-1, name);
    }
    
}