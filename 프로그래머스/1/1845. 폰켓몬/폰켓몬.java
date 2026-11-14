import java.util.*;

class Solution {
    
    // 조합...?
    // 음 HashMap에 저장하면 3,1,2,3 -> 3,1,2 이렇게 됨. size 3
    // HashMap에서 values().size()가 카디널리티임.
    // 뽑길 원하는건 2임.
    // 그럼 잘 뽑아봤자 2임.
    // 카디널리티 > 뽑고자 하는 수이면 뽑고자하는 수.
    // 카디널리티 <= 뽑고자 하는 수이면 카디널리티.
    
    public int solution(int[] nums) {
        // <포켓몬넘버, 수>
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 1) + 1); // 사실 그냥 Put해도 상관X
        }
        
        int cardinality = hm.values().size();
        int pullOutRequest = nums.length / 2;
        if(cardinality > pullOutRequest){
            return pullOutRequest;
        }
        
        return cardinality;
    }
    
}