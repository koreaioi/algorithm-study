import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> hm = new HashMap<>();
        for(String[] clothAndCategory : clothes){
            hm.put(clothAndCategory[1], hm.getOrDefault(clothAndCategory[1], 0) + 1);
        }
        
        int answer = 1;
        for(int value : hm.values()){
            System.out.println(value);
            answer = answer * (value+1);
        }
        
        return answer -1;
    }
    
    // a, b, X
    // ㄱ, ㄴ, X
    // @, !, X
    
    // a, b
    // ㄱ
    // 이건 포함하지 않는것 경우의 수로 계산
    // 따라서
    // a,b,X
    // ㄱ, X
    // 이때 X와 X가 선택될 경우의수는 빼야함
    // 따라서 2*3 -1 이건가?
}